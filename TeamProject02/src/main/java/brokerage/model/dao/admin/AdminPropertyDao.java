package brokerage.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import brokerage.model.dao.Dao;
import brokerage.model.dto.PropertyDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdminPropertyDao extends Dao {
	@Getter
	private static AdminPropertyDao instance = new AdminPropertyDao();
	
	/** 등록된 매물 전체 출력 SQL */
	public ArrayList<PropertyDto> findAll() {
		ArrayList<PropertyDto> result = new ArrayList<>();
		try {
			String sql = "select p.*, m.mname from property as p "
					+ "inner join member as m on m.mno = p.mno "
					+ "order by p.pno asc;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PropertyDto dto = new PropertyDto();
				dto.setPno(rs.getInt("pno")); dto.setPcategory(rs.getInt("pcategory"));
				dto.setPaddress(rs.getString("paddress")); dto.setPyear(rs.getString("pyear"));
				dto.setPdate(rs.getString("pdate")); dto.setPsell(rs.getInt("psell"));
				dto.setMno(rs.getInt("mno")); dto.setMname(rs.getString("mname"));
				result.add(dto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	// AdminPropertyDetailController.java
	/** 등록된 매물 상세보기 SQL */
	public PropertyDto detail(int pno) {
		PropertyDto result = new PropertyDto();
		try {
			String sql = "select p.*, m.mname from property as p "
					+ "inner join member as m on m.mno = p.mno where pno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result.setPno(rs.getInt("pno"));
				result.setPcategory(rs.getInt("pcategory"));
				result.setPaddress(rs.getString("paddress"));
				result.setPlat(rs.getDouble("plat"));
				result.setPlong(rs.getDouble("plong"));
				result.setPbuilding(rs.getInt("pbuilding"));
				result.setPstorey(rs.getInt("pstorey"));
				result.setParea(rs.getDouble("parea"));
				result.setPyear(rs.getString("pyear"));
				result.setPstructure(rs.getString("pstructure"));
				result.setPuser(rs.getString("puser"));
				result.setPadd(rs.getString("padd"));
				result.setPdate(rs.getString("pdate"));
				result.setPsell(rs.getInt("psell"));
				result.setMno(rs.getInt("mno"));
				result.setMname(rs.getString("mname"));
				result.setMprice(rs.getInt("mprice"));
				
				sql = "select phname from photo where pno = ?;";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, pno);
				rs = ps.executeQuery();
				if(rs.next()) {
					result.setPhoto("/TeamProject02/img/" + rs.getString("phname"));
				}
				
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	
}
