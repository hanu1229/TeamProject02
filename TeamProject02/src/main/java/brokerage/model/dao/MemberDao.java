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
	
	// 회원정보 수정 메소드
	public boolean update(MemberDto memberDto) {
		try {
			// sql 작성
			String sql = "update member set mpwd = ? , mname = ? , mphone = ? where mno = ?";
			// DB에 sql 기재
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMpwd());
			ps.setString(2, memberDto.getMname());
			ps.setString(3, memberDto.getMphone());
			ps.setInt(4, memberDto.getMno());
			// 기재된 sql 실행 후 결과 반환
			int count = ps.executeUpdate();
			// 결과에 따른 처리 반환
			if(count == 1) {return true;} // 수정 성공
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false; // 수정 실패시
	}
	
	// 회원정보 찾기 메소드
	// 회원 이름과 전화번호를 이용해 회원 ID와 비밀번호 찾기
	public MemberDto findMember(MemberDto memberDto) {
	    try {
	        // SQL 작성
	        String sql = "select mno, mid, mpwd from member where mname = ? and mphone = ?";

	        // PreparedStatement 생성
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, memberDto.getMname());  // DTO에서 회원 이름 가져오기
	        ps.setString(2, memberDto.getMphone()); // DTO에서 전화번호 가져오기

	        // SQL 실행 후 결과 조회
	        ResultSet rs = ps.executeQuery();

	        // 결과가 존재하면 DTO 객체로 반환
	        if (rs.next()) {
	            return new MemberDto(
	                rs.getInt("mno"),     // 회원번호
	                rs.getString("mid"),  // 회원 아이디
	                rs.getString("mpwd"), // 회원 비밀번호
	                null,                 // mname (조회 필요 없음)
	                null,                 // mphone (조회 필요 없음)
	                null,                 // mdate (조회 필요 없음)
	                0                     // msell (조회 필요 없음)
	            );
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL 실행 오류: " + e);
	    }
	    return null; // 회원 정보를 찾지 못한 경우 null 반환
	}


} // c end
