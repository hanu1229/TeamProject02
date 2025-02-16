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
	public ArrayList<PropertyDto> findByPno( int mno ){
		ArrayList<PropertyDto> list = new ArrayList<PropertyDto>();
		try {
			String sql = " select * from property p inner join member m on p.mno = m.mno "
					+ " where p.mno = ? "
					+ " order by p.pno desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
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
