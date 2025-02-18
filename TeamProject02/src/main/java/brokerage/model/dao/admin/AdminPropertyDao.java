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
	public ArrayList<PropertyDto> findAll(int page) {
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
}
