package brokerage.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import brokerage.model.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE) // 클래스내 디폴트생성자를 private 적용
public class MemberDao extends Dao{
	
	// 싱글톤 
	// [1] 멤버변수에 static 인스턴스를 만든다.
	// [2] 디폴트 생성자를 private 한다.
	// [3] static 인스턴스를 반환하는 메소드 만든다.
	
	@Getter // 지정된 멤버변수에 getter 적용
	private static MemberDao instance = new MemberDao();
	
	// 회원가입 메소드
	public int signup(MemberDto memberDto) {
		try {
			String sql ="insert into member( mid , mpwd , mname , mphone ) values( ? , ? , ? , ? )";
			PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ps.setString(3, memberDto.getMname());
			ps.setString(4, memberDto.getMphone());
			int count = ps.executeUpdate();
			if(count == 1) {
				ResultSet rs = ps.getGeneratedKeys(); // auto 생성키 반환
				if(rs.next()) {
					int mno = rs.getInt(1);
					return mno; // 등록한 회원번호 반환
				}
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return 0; // 실패 시 0
	}
	
	// 로그인 메소드
	public int login(MemberDto memberDto) {
		try {
			String sql = "select mno from member where mid =? and mpwd = ?";
			// sql 기재
			PreparedStatement ps = conn.prepareStatement(sql);
			// sql에 매개변수 값 대입
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			// 기재된 sql 실행 후 결과 반환
			ResultSet rs = ps.executeQuery();
			// 결과에 따른 처리 및 반환
			if(rs.next()) {
				int mno = rs.getInt("mno");
				return mno; // 0 초과하면 로그인 성공한 회원번호 반환	
			}
		}catch(SQLException e) {System.out.println(e);}
		return 0; // 0이면 로그인 실패
	}
	
} // c end
