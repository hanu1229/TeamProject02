package brokerage.model.dao;

import java.beans.PropertyChangeEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import brokerage.model.dto.MemberDto;
import brokerage.model.dto.PropertyDto;
import brokerage.model.dto.SellDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE ) // 클래스내 디폴트 생성자 private
public class EstateDao extends Dao{
	
	@Getter
	private static EstateDao instance = new EstateDao();
	
	// 매물 신청
	public boolean estateApply( SellDto sellDto ) {
		try {
			String sql = "insert into sell_request( sadd , sfile , mno ) values( ? , ? , ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sellDto.getSadd() );
			ps.setString(2, sellDto.getSfile() );
			ps.setInt(3, sellDto.getMno() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
		
	} // f end
	
	// 매물의 전체 개수 조회 (특정 회원의 매물만 조회)
	public int getTotalSize(int mno, int pcategory) {
	    try {
	        String sql;
	        PreparedStatement ps;

	        if (pcategory == 10) { // 전체 카테고리 조회
	            sql = "SELECT COUNT(*) FROM property WHERE mno = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, mno);
	        } else { // 특정 카테고리 조회
	            sql = "SELECT COUNT(*) FROM property WHERE mno = ? AND pcategory = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, mno);
	            ps.setInt(2, pcategory);
	        }

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            int totalSize = rs.getInt(1);
	            System.out.println("Total Size: " + totalSize);  // ✅ 디버깅용 로그
	            return totalSize;
	        }
	    } catch (Exception e) {
	        System.out.println("getTotalSize SQL Error: " + e);
	    }
	    return 0;
	}
	
	// 매물 전체 개수 조회
	public ArrayList<PropertyDto> findAll(int mno, int pcategory, int startRow, int display) {
	    ArrayList<PropertyDto> list = new ArrayList<>();
	    try {
	        String sql;
	        PreparedStatement ps;

	        if (pcategory == 10) {  // 모든 카테고리의 매물을 조회
	            sql = "SELECT * FROM property p "
	                + "INNER JOIN member m ON p.mno = m.mno "
	                + "WHERE p.mno = ? "
	                + "ORDER BY p.pno DESC "
	                + "LIMIT ?, ?";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, mno);
	            ps.setInt(2, startRow);  // ✅ startRow 값 설정
	            ps.setInt(3, display);   // ✅ display 값 설정
	        } else {  // 특정 카테고리만 조회
	            sql = "SELECT * FROM property p "
	                + "INNER JOIN member m ON p.mno = m.mno "
	                + "WHERE p.mno = ? AND p.pcategory = ? "
	                + "ORDER BY p.pno DESC "
	                + "LIMIT ?, ?";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, mno);
	            ps.setInt(2, pcategory);
	            ps.setInt(3, startRow);
	            ps.setInt(4, display);
	        }

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            PropertyDto propertyDto = new PropertyDto();
	            propertyDto.setPno(rs.getInt("pno"));
	            propertyDto.setPcategory(rs.getInt("pcategory"));
	            propertyDto.setPaddress(rs.getString("paddress"));
	            propertyDto.setPlat(rs.getDouble("plat"));
	            propertyDto.setPlong(rs.getDouble("plong"));
	            propertyDto.setPbuilding(rs.getInt("pbuilding"));
	            propertyDto.setPstorey(rs.getInt("pstorey"));
	            propertyDto.setParea(rs.getDouble("parea"));
	            propertyDto.setPyear(rs.getString("pyear"));
	            propertyDto.setPstructure(rs.getString("pstructure"));
	            propertyDto.setPuser(rs.getString("puser"));
	            propertyDto.setPadd(rs.getString("padd"));
	            propertyDto.setPdate(rs.getString("pdate"));
	            propertyDto.setPsell(rs.getInt("psell"));
	            propertyDto.setMno(rs.getInt("mno"));
	            list.add(propertyDto);
	        }
	    } catch (SQLException e) {
	        System.out.println("findAll SQL Error: " + e);
	    }
	    return list;
	} // f end

	// 본인 매물 수정
	public boolean estateUpdate(PropertyDto propertyDto) {
	    try {
	        String sql = "update property set padd = ? where pno = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, propertyDto.getPadd());  // 수정할 추가내용
	        ps.setInt(2, propertyDto.getPno());  // 수정할 매물 번호
	        int count = ps.executeUpdate();
	        if ( count == 1) { return true; }
	    } catch (SQLException e) { System.out.println( e ); }
	    return false;
	} // f end
	
//	// 본인 매물 삭제
//	public boolean estateDelete( int pno ) {
//		try {
//			String sql = "delete from property where pno = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, pno);
// 			int count = ps.executeUpdate();
// 			if( count == 1 ) { return true; }
//		}catch( SQLException e ) { System.out.println( e ); }
//		return false;
//	} // f end
	
	// 본인 매물 판매 중지 
	public boolean estateStop( PropertyDto propertyDto ) {
		try {
	        String sql = "update property set psell = 2 where pno = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, propertyDto.getPno());  // 수정할 매물 번호
	        int count = ps.executeUpdate();
	        if ( count == 1) { return true; }
	    } catch (SQLException e) { System.out.println( e ); }
	    return false;
	} // f end
	
	// 판매권한 신청 ( 1 -> 3 )
	public boolean esellUpdate( MemberDto memberDto ) {
		try {
			String sql = "update member set msell_state = 3 where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setInt(1, memberDto.getMno() );  // 현재는 1로 설정해서 테스트
	        System.out.println(ps);
	        
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
} // c end
