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
	
	/** 회원 개별 조회 */
	public MemberDto find(MemberDto memberDto) {
		MemberDto result = new MemberDto();
		try {
			String sql = "select * from member where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getMno());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result.setMno(rs.getInt("mno"));
				result.setMid(rs.getString("mid"));
				result.setMname(rs.getString("mname"));
				result.setMphone(rs.getString("mphone"));
				result.setMdate(rs.getString("mdate"));
				result.setMsell(rs.getInt("msell_state"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 회원 판매권한 수정 SQL */
	public boolean updateMsell(MemberDto memberDto) {
		try {
			String sql = "update member set msell_state = ? where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getMsell());
			ps.setInt(2, memberDto.getMno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 회원 삭제 SQL */
	public boolean deleteMember(int mno) {
		try {
			String sql = "delete from member where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
