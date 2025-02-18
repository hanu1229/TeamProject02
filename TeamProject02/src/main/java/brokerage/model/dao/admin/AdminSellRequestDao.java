package brokerage.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import brokerage.model.dao.Dao;
import brokerage.model.dto.SellDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdminSellRequestDao extends Dao {
	@Getter
	private static AdminSellRequestDao instance = new AdminSellRequestDao();
	
	/** 신청한 매물 전체 조회 SQL */
	public ArrayList<SellDto> findAll() {
		ArrayList<SellDto> result = new ArrayList<>();
		try {
			String sql = "select s.*, m.mname from sell_request as s inner join member as m on m.mno = s.mno order by s.sno;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SellDto dto = new SellDto();
				dto.setSno(rs.getInt("sno")); dto.setSfile(rs.getString("sfile"));
				dto.setSdate(rs.getString("sdate")); dto.setSstate(rs.getInt("sstate"));
				dto.setSadd(rs.getString("sadd")); dto.setMno(rs.getInt("mno")); dto.setMname(rs.getString("mname"));
				result.add(dto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 신청한 매물 수락 또는 거절 */
	public SellDto update(SellDto sellDto) {
		SellDto result = new SellDto();
		try {
			String sql = "update sell_request set sstate = ? where sno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sellDto.getSstate());
			ps.setInt(2, sellDto.getSno());
			int count = ps.executeUpdate();
			if(count == 1) { 
				sql = "select s.*, m.mname from sell_request as s inner join member as m on m.mno = s.mno where sno = ? order by s.sno;";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, sellDto.getSno());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					result.setSno(rs.getInt("sno")); result.setSfile(rs.getString("sfile"));
					result.setSdate(rs.getString("sdate")); result.setSstate(rs.getInt("sstate"));
					result.setSadd(rs.getString("sadd")); result.setMname(rs.getString("mname"));
					result.setMno(rs.getInt("mno"));
				}
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
}
