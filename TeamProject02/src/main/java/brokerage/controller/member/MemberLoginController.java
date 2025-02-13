package brokerage.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.MemberDao;
import brokerage.model.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/afiliado/login")
public class MemberLoginController extends HttpServlet{
	// login
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP 요청(JSON 데이터를 파싱하기 위한 ObjectMapper 생성)
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);  // 클라이언트에서 보낸 JSON 데이터를 Java 객체(MemberDto)로 변환
		
		// 유효성 검사 (아이디 / 비밀번호 칸이 비어있는 상태로 로그인 시도하는지 확인)
			// 사용자 입력값 가져오기
			String mid = memberDto.getMid();
			String mpwd = memberDto.getMpwd();
			// 아이디 또는 비밀번호가 비어있는(공백인) 경우
			if (mid == null || mid.trim().isEmpty() || mpwd == null || mpwd.trim().isEmpty()) { // .trim() : 문자열의 앞뒤 공백(스페이스바)을 제거하는 역할 // .isEmpty() : 문자열이 비어있는지 확인하는 기능
				// *** trim().isEmpty() : trim()으로 문자열 앞뒤 공백을 제거한 후, isEmpty()를 사용하여 완전히 비어 있는지 확인하는 것 // 사용자가 공백만 입력했을 때도 "빈 문자열"로 간주하는 유용한 방법
			    resp.setContentType("application/json"); // 응답 타입 JSON 설정
			    resp.getWriter().write("{\"error\": \"아이디와 비밀번호는 필수 입력 항목입니다.\"}");
			    return; // 요청 종료
			}
		// Dao 전달 => 응답
		int loginMno = MemberDao.getInstance().login(memberDto);
		
			if( loginMno > 0 ) {
				HttpSession session = req.getSession(); // 세션에 속성 추가 ( 톰켓 서버의 저장소 / 메모리 )
				session.setAttribute("loginMno", loginMno); // 세션에 속성 추가 : 톰켓 서버에 데이터 저장
				session.setMaxInactiveInterval(60*60); // 60분 제한
			//HTTP 응답
				resp.setContentType("application/json");
				resp.getWriter().print(loginMno); // 로그인 성공 JSON 데이터 전송
			} else { // 아이디 / 비밀번호가 일치하지 않을 시 (로그인 실패시)
				resp.getWriter().write("{\"error\": \"아이디 또는 비밀번호가 올바르지 않습니다.\"}"); // JSON 응답}
			}
	} // post end
	
	// logout
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
		// Dao 전달 => 응답
		Object object = session.getAttribute("loginMno"); // 세션 속성값 불러오기
		boolean logOut = false;
		if(object != null) {// 속성값이 존재하면 속성값 제거 (로그아웃)
			session.removeAttribute("loginMno");
			logOut = true;
		} // if end
		resp.setContentType("application/json");
		resp.getWriter().print(logOut);
		
	}
}// c end
