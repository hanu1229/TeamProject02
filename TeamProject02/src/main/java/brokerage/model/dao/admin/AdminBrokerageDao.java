package brokerage.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import brokerage.model.dao.Dao;
import brokerage.model.dto.BrokerageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdminBrokerageDao extends Dao {
	@Getter
	private static AdminBrokerageDao instance = new AdminBrokerageDao();
	
	/** 중개한 매물 전체 출력 SQL */
	public ArrayList<BrokerageDto> findAll() {
		ArrayList<BrokerageDto> result = new ArrayList<>();
		try {
			String sql = "select b.*, m.mname from brokerage as b "
					+ "inner join member as m on m.mno = b.mno order by b.bno asc;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BrokerageDto dto = new BrokerageDto();
				dto.setBno(rs.getInt("bno")); dto.setBfile(rs.getString("bfile"));
				dto.setBdate(rs.getString("bdate")); dto.setBmanager(rs.getString("bmanager"));
				dto.setMno(rs.getInt("mno")); dto.setPno(rs.getInt("pno"));
				dto.setMname(rs.getString("mname")); dto.setBcomment(rs.getString("bcomment"));
				result.add(dto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 중개한 매물 파일 다운로드 */
	
	
}
