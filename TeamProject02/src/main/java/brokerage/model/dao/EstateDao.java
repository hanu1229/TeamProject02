package brokerage.model.dao;

import java.beans.PropertyChangeEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	// 본인 매물 조회
	public ArrayList<PropertyDto> findByPno( int mno , int pcategory , int startRow , int display ){
		ArrayList<PropertyDto> list = new ArrayList<PropertyDto>();
		try {
			String sql = " select * from property p "
					+ " inner join member  m on p.mno = m.mno "
					+ " where p.mno = ? and p.pcategory = ? "
					+ " order by p.pno desc "
					+ " limit ? , ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2, pcategory);
			ps.setInt(3, startRow);
			ps.setInt(4, display);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				PropertyDto propertyDto = new PropertyDto();
				propertyDto.setPno( rs.getInt("pno") );
				propertyDto.setPcategory( rs.getInt("pcategory") );
				propertyDto.setPaddress( rs.getString("paddress") );
				propertyDto.setPbuilding( rs.getInt("pbuilding") );
				propertyDto.setPstorey( rs.getInt("pstorey") );
				propertyDto.setParea( rs.getDouble("parea") );
				propertyDto.setPyear( rs.getString("pyear") );
				propertyDto.setPstructure( rs.getString("pstructure") );
				propertyDto.setPuser( rs.getString("puser") );
				propertyDto.setPadd( rs.getString("padd") );
				propertyDto.setPdate( rs.getString("pdate") );
				propertyDto.setPsell( rs.getInt("psell") );
				propertyDto.setMno( rs.getInt("mno") );
				list.add(propertyDto);
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return list;
	} // f end
	
	// 카테고리 별 게시물 개수
	public int getTotalSize( int pcategory ) {
		try {
			String sql = "select count(*) from property where pcategory = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pcategory);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) { return rs.getInt( 1 ); }
		}catch (Exception e) { System.out.println( e ); }
		return 0;
	} // f end
	
    // 카테고리 10일 경우 모든 매물 수 가져오는 메소드
    public int getAllPropertiesSize() {
        String sql = "SELECT COUNT(*) FROM property";  // 모든 매물 수 구하기
        int totalSize = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                totalSize = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalSize;
    } // f end
    
 // 카테고리 0일 경우 모든 매물 가져오는 메소드
    public List<PropertyDto> getAllProperties(int mno, int startRow, int display) {
        String sql = "SELECT * FROM property LIMIT ?, ?";  // 모든 매물 가져오기
        List<PropertyDto> result = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, display);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setPno(rs.getInt("pno") );
                propertyDto.setPcategory(rs.getInt("pcategory") );
                propertyDto.setPaddress(rs.getString("paddress") );
                propertyDto.setPbuilding( rs.getInt("pbuilding") );
                propertyDto.setPstorey(rs.getInt("pstorey") );
                propertyDto.setParea(rs.getInt("parea") );
                propertyDto.setPyear( rs.getString("pyear") );
                propertyDto.setPstructure(rs.getString("pstructure") );
                propertyDto.setPuser(rs.getString("puser") );
                propertyDto.setPadd(rs.getString("padd") );
                propertyDto.setPdate(rs.getString("pdate") );
                propertyDto.setPsell(rs.getInt("psell") );
                result.add(propertyDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
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
	
	// 본인 매물 삭제
	public boolean estateDelete( int pno ) {
		try {
			String sql = "delete from property where pno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
 			int count = ps.executeUpdate();
 			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
} // c end
