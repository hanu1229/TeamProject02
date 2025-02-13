package brokerage.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import brokerage.model.dao.Dao;
import brokerage.model.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AdminLoginDao extends Dao {
	@Getter
	private static AdminLoginDao instance = new AdminLoginDao();
	
	/** 관리자 로그인 SQL */
	public MemberDto login(MemberDto memberDto) {
		MemberDto result = new MemberDto();
		try {
			String sql = "select mno, msell_state from member where mid = ? and mpwd = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				// 데이터베이스에서 가져온 msell_state값을 저장
				result.setMsell(rs.getInt("msell_state"));
				// 저장한 값이 9이면 mno를 저장 후 저장한 MemberDto를 반환
				if(result.getMsell() == 9) {
					result.setMno(rs.getInt("mno"));
					return result;
				}
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 로그인 체크 SQL */
	public String loginCheck(int mno) {
		try {
			String sql = "select mname from member where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("mname");
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	
}
