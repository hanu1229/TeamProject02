package brokerage.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import brokerage.model.dto.PropertyDto;

public class ClientDao extends Dao {

	//싱글톤
	private static ClientDao clientDao = new ClientDao();
	private ClientDao() {
		super();//부모 클래스 생성자 호출
	}
	public static ClientDao getInstance() {
		return clientDao;
	}
	
	//전체 매물 수 조회
	public int getTotalCount() {
		 String sql = "SELECT COUNT(*) FROM property";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			
		}catch (Exception e) {
			System.out.println("getTotalCount 예외:" +e);
		}
		return 0;
	}
	
	//전체 매물 목록 조회 (페이징)
	public List<PropertyDto>findAll(int page){
		List<PropertyDto>list = new ArrayList<>();
		String sql =  "SELECT pno, pcategory, paddress, parea, pstorey, pyear, padd, psell " +
                "FROM property ORDER BY pno DESC LIMIT ?, 10";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*10);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PropertyDto dto = new PropertyDto();
				dto.setPno(rs.getInt("pno"));
				dto.setPcategory(rs.getInt("pcategory"));
				dto.setPaddress(rs.getString("paddress"));
				dto.setParea(rs.getDouble("parea"));
				dto.setPstorey(rs.getInt("pstorey"));
				dto.setPyear(rs.getString("pyear"));
				dto.setPsell(rs.getInt("psell"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println("findAll 예외" + e);
			// TODO: handle exception
		}
		return list;
	}// cend
	
	
	//매물 개별 조회 
	public PropertyDto findById(int pno) {
		String sql =  "SELECT pno, pcategory, paddress, parea, pstorey, pyear, padd, psell " +
                "FROM property WHERE pno = ?";
		try {
			 PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, pno);
	            ResultSet rs = ps.executeQuery();
	            
	            if(rs.next()) {
	            	PropertyDto dto = new PropertyDto();
	            	dto.setPno(rs.getInt("pno"));
	                dto.setPcategory(rs.getInt("pcategory"));
	                dto.setPaddress(rs.getString("paddress"));
	                dto.setParea(rs.getDouble("parea"));
	                dto.setPstorey(rs.getInt("pstorey"));
	                dto.setPyear(rs.getString("pyear"));
	                dto.setPadd(rs.getString("padd"));
	                dto.setPsell(rs.getInt("psell"));
	            	
	            	return dto;
	            }
	            
	            
		}catch (Exception e) {
			System.out.println("findById 예외:" + e);
		}
		return null;
	
	} //  c end
	
	
	//매물 상세 조회
	public PropertyDto findDetailById(int pno) {
		 String sql = "SELECT p.*, ph.phname " +
                 "FROM property p " +
                 "LEFT JOIN photo ph ON p.pno = ph.pno " +
                 "WHERE p.pno = ?";
		 
		 try {
			 PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, pno);
	            ResultSet rs = ps.executeQuery();
			 
	            if(rs.next()) {
	            	PropertyDto dto = new PropertyDto();
	            	 dto.setPno(rs.getInt("pno"));
	                 dto.setPcategory(rs.getInt("pcategory"));
	                 dto.setPaddress(rs.getString("paddress"));
	                 dto.setPlat(rs.getDouble("plat"));
	                 dto.setPlong(rs.getDouble("plong"));
	                 dto.setPbuilding(rs.getInt("pbuilding"));
	                 dto.setPstorey(rs.getInt("pstorey"));
	                 dto.setParea(rs.getDouble("parea"));
	                 dto.setPyear(rs.getString("pyear"));
	                 dto.setPstructure(rs.getString("pstructure"));
	                 dto.setPuser(rs.getString("puser"));
	                 dto.setPadd(rs.getString("padd"));
	                 dto.setPdate(rs.getString("pdate"));
	                 dto.setPsell(rs.getInt("psell"));
	            
	              // 이미지 정보가 있다면 추가하기(주석처리만 빼주시면될듯)
	                 //String phname = rs.getString("phname");
	                 //if(phname!=null) {
	                	// dto.setPhotoName(phname);
	                 
	                 //}// if end
	                 //retrun dto;
	            } 
	           
			 
		 }catch (Exception e) {
			 
			 System.out.println("findDetailById 예외 :" + e);
		}
		 return null;
	}// cend
	
}// class end
