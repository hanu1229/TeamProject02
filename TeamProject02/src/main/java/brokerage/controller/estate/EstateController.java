package brokerage.controller.estate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.EstateDao;
import brokerage.model.dto.PageDto;
import brokerage.model.dto.PropertyDto;
import brokerage.model.dto.SellDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/estate/info")
public class EstateController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("EstateController dopost!!");
	    
	    // 1. 업로드 경로 가져오기
	    String uploadPath = req.getServletContext().getRealPath("/upload");
	    System.out.println(uploadPath);

	    // 2. 만일 해당 경로가 없으면 만들어주기.
	    File file = new File(uploadPath);
	    if (file.exists()) {} // 경로가 존재하면 아무 작업 안함
	    else { file.mkdir(); } // 경로가 존재하지 않으면 경로 생성

	    // 3. 파일 업로드 설정 , DiskFileItemFactory클래스
	    System.out.println(file);
	    DiskFileItemFactory factory = new DiskFileItemFactory(); // 업로드 설정 객체 생성
	    factory.setRepository(file); // 업로드된 파일을 임시로 저장할 디렉터리를 설정
	    factory.setSizeThreshold(1024 * 1024 * 1024); // 1GB 제한
	    factory.setDefaultCharset("UTF-8"); // 한글 인코딩 설정

	    // 4. 설정된 객체를 서블릿 업로드 객체에 대입
	    ServletFileUpload fileupload = new ServletFileUpload(factory);

	    // 5. HTTP 요청 객체 내 데이터 파싱
	    String filename = "default.pdf";
	    
	    try {
	        // 6. 파일 목록 가져오기
	        List<FileItem> fileList = fileupload.parseRequest(req);
	        SellDto sellDto = new SellDto(); // SellDto 객체 생성

	        // 7. 파싱된 자료를 처리
	        for (FileItem item : fileList) { 
	            // 8. 일반 텍스트 필드일 경우 처리
	            if (item.isFormField()) {
	                if (item.getFieldName().equals("sadd")) {
	                    sellDto.setSadd(item.getString("UTF-8")); // 추가 내용 (UTF-8 인코딩 적용)
	                }
	            } else { // 9. 첨부파일 처리
	                if (!item.getName().isEmpty()) {
	                    filename = UUID.randomUUID().toString() + "-" + item.getName().replaceAll("-", "_");
	                    // 업로드할 경로와 파일명 조합하여 경로 만들기
	                    File uploadFile = new File(uploadPath + "/" + filename);
	                    item.write(uploadFile);
	                    sellDto.setSfile(filename); // 업로드된 파일명을 DTO에 저장
	                }
	            }
	        }

	        // 10. 세션에서 로그인된 회원번호(mno) 가져오기
	        HttpSession session = req.getSession(); // 세션 객체 가져오기
	        Object object = session.getAttribute("loginMno"); // 세션에서 "loginMno" 가져오기
	        
	        if (object != null) {
	            int loginMno = (Integer) object; // Object를 int로 변환
	            sellDto.setMno(loginMno); // 로그인된 회원 번호를 SellDto에 설정
	        }

	        // 11. DTO 내용 확인 (디버깅용)
	        System.out.println(sellDto);

	        // 12. 매물 신청 저장 처리 (매물 신청 DB 저장)
	        boolean result = EstateDao.getInstance().estateApply(sellDto);
	        
	        // 13. JSON 응답 반환
	        resp.setContentType("application/json");
	        resp.getWriter().print(result);
	        
	    } catch (Exception e) { System.out.println("업로드 실패 : " + e); }
		
		
	} // f end
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("estateController doGet ok");

	    // 기본 mno 설정 (로그인 전에는 1로 설정, 나중에 세션에서 로그인한 회원 번호를 받아올 것)
	    int mno = 1;  // 임시로 1로 설정, 로그인 후에는 세션에서 mno 값을 받아올 것

	    // [1] 요청 매개변수: pcategory (카테고리 번호), page (페이지 번호) 가져오기
	    String pcategoryStr = req.getParameter("pcategory");  // 카테고리 번호 (0: 아파트, 1: 주택, 2: 오피스텔 등)
	    String pageStr = req.getParameter("page");  // 페이지 번호

	    // pcategory와 page를 숫자로 변환
	    int pcategory = Integer.parseInt(pcategoryStr);  // 카테고리 번호 (0, 1, 2 등)
	    int page = Integer.parseInt(pageStr);  // 페이지 번호

	    // * 페이징 처리에 필요한 자료 준비
	    int display = 10;  // 한 페이지에 출력할 매물 수 (10개)
	    int startRow = (page - 1) * display;  // 페이지 시작 번호 계산

	    // [2] EstateDao에게 본인 매물 요청하고 결과 받기
	    int totalSize = EstateDao.getInstance().getTotalSize(pcategory);  // 해당 카테고리 매물의 전체 수 구하기

	    // 3. 전체 페이지 수 계산
	    int totalPage = (totalSize % display == 0) ? totalSize / display : totalSize / display + 1;

	    // totalPage가 0일 경우에는 페이지네이션을 표시하지 않도록 처리
	    if (totalPage == 0) {
	        resp.setContentType("application/json");
	        resp.getWriter().print("{}");  // 빈 JSON 반환
	        return;
	    }

	    // 페이지 번호가 totalPage를 초과할 경우, 마지막 페이지로 설정
	    if (page > totalPage) {
	        page = totalPage;
	    }

	    // 4. 페이지 버튼의 개수 (5개 버튼씩 출력)
	    int btnSize = 5;

	    // 5. 시작 버튼 번호 구하기
	    int startBtn = ((page - 1) / btnSize) * btnSize + 1;

	    // 6. 끝 버튼 번호 구하기
	    int endBtn = startBtn + (btnSize - 1);

	    // 만약 끝 버튼 번호가 전체 페이지 수보다 크면 끝 번호를 전체 페이지 수로 설정
	    if (endBtn > totalPage) endBtn = totalPage;

	    // [3] 실제 데이터 가져오기 (pcategory와 page를 사용하여 매물 가져오기)
	    List<PropertyDto> result = EstateDao.getInstance().findByPno(mno, pcategory, startRow, display);

	    // [4] PageDto 객체 생성
	    PageDto pageDto = new PageDto();
	    pageDto.setTotalPage(totalPage);  // 전체 페이지 수
	    pageDto.setCurrentPage(page);  // 현재 페이지 번호
	    pageDto.setStartbtn(startBtn);  // 페이지 버튼 시작 번호
	    pageDto.setEndbtn(endBtn);  // 페이지 버튼 끝 번호
	    pageDto.setProperties(result);  // 매물 목록

	    // [5] PageDto 객체를 JSON 형식의 문자열로 변환
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonResult = mapper.writeValueAsString(pageDto);  // PageDto 객체를 JSON으로 변환

	    // [6] HTTP 응답으로 JSON 데이터 반환
	    resp.setContentType("application/json");
	    resp.getWriter().print(jsonResult);
	} // f end
	
	// 본인 매물 정보 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("EstateController doput!!");
	    ObjectMapper mapper = new ObjectMapper();
	    PropertyDto propertyDto = mapper.readValue(req.getReader(), PropertyDto.class);

	    // 클라이언트에서 전달된 값 확인
	    System.out.println("Received padd: " + propertyDto.getPadd());
	    System.out.println("Received pno: " + propertyDto.getPno());

	    boolean result = EstateDao.getInstance().estateUpdate(propertyDto);
	    resp.setContentType("application/json");
	    resp.getWriter().print(result);
	}
	
	// 본인 매물 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EstateController dodelete!!");
		int pno = Integer.parseInt( req.getParameter("pno") );
		boolean result = EstateDao.getInstance().estateDelete( pno );
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
} // c end
