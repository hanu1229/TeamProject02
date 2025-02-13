package brokerage.service;

import java.util.List;
import java.util.Map;

import brokerage.model.dao.ClientDao;
import brokerage.model.dto.PageDto;
import brokerage.model.dto.PropertyDto;

public class ClientService {

	//싱글톤
	private static ClientService clientService = new ClientService();
	private ClientService(){}
	public static ClientService getInstance() {
		return clientService;
	}
	
	//DAO 객체 가져오기
	
	private ClientDao clientDao = ClientDao.getInstance();
	
	//1.전체 매물 목록 조회 ( 페이징 처리)
	
	public PageDto getPropertyList(int page) {
		//1)전체 게시물 수 계산
		int totalCount = clientDao.getTotalCount();
		
		//2) 전체 페이지 수 계산 ( 한 페이지당 10개씩)
		int totalPage =(totalCount +9 )/10;
		
		//3 ) 페이지 유효성 검사
		
		if(page <=0 || page >totalPage) {
			page = 1;
		}//if end
	
		// 2 ) 매물목록 가져오기
		List<PropertyDto>properties = clientDao.findAll(page);
		
		//page Dto 생성 하고 반환
		PageDto pageDto = new PageDto();
		pageDto.setTotalPage(totalPage);
		pageDto.setCurrentPage(page);
		pageDto.setProperties(properties);
		
		return pageDto;
	
	}// c end
	
	//2.매물 개별 조회
	public PropertyDto getProperty(int pno) {
		PropertyDto property = clientDao.findById(pno);
		if(property == null) {
			throw new RuntimeException("해당 매물이 존재하지않습니다.");
		}
		return property;
	}// cend
	
	//3. 매물 상세 조회
	public PropertyDto getPropertyDetail(int pno) {
		 PropertyDto property = clientDao.findDetailById(pno);
		  if(property == null) {
	           throw new RuntimeException("해당 매물이 존재하지 않습니다.");
		  }
		  return property;
	}// c end 
	
	
	//4.매물 문의하기
	public Map<String, Object>inquireProperty(int pno, int buyerMno){
		// 매물 존재여부 확인
		PropertyDto property = clientDao.findById(pno);
		if(property == null) {
			throw new RuntimeException("[안내] 해당 매물이 존재하지 않습니다.");
		}
		
		// 이미 판료된 매물인지 확인
		if(property.getPsell()==1) {
			throw new RuntimeException("[안내] 이미 판매완료된 매물입니다.");
		}// if end
		
		//3) 판매자 정보 조회 (member 테이블에서 직접 조회함)
		Map<String, Object>sellerInfo = clientDao.getSellerInfo(pno);
		if(sellerInfo == null) {
			throw new RuntimeException("[안내] 판매자 정보를 찾을 수 없습니다.");
		}
		
		//4)문의내역 저장 (buy_request 테이블에 저장)
		if(!clientDao.saveBuyRequest(pno, buyerMno)) {
			throw new RuntimeException("[안내] 문의하기 처리 중 오류가 발생했습니다.");
		}
		  return sellerInfo;  // 판매자 정보(이름, 연락처 등) 반환
	}// c end
	
}// class end
