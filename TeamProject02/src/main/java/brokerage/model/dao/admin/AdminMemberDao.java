package brokerage.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import brokerage.model.dao.Dao;
import brokerage.model.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AdminMemberDao extends Dao {
	@Getter
	private static AdminMemberDao instance = new AdminMemberDao();
	
	/** 회원 목록 전체 출력 SQL */
	public ArrayList<MemberDto> findAll() {
		ArrayList<MemberDto> result = new ArrayList<>();
		try {
			String sql = "select * from member;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setMno(rs.getInt("mno"));
				dto.setMid(rs.getString("mid"));
				dto.setMname(rs.getString("mname"));
				dto.setMphone(rs.getString("mphone"));
				dto.setMdate(rs.getString("mdate"));
				dto.setMsell(rs.getInt("msell_state"));
				result.add(dto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
}
