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
@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP 요청
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		
		// 유효성 검사
		
		// Dao 전달 => 응답
		int loginMno = MemberDao.getInstance().login(memberDto);
		
			if( loginMno > 0 ) {
				HttpSession session = req.getSession(); // 세션에 속성 추가 ( 톰켓 서버의 저장소 / 메모리 )
				session.setAttribute("loginMno", loginMno); // 세션에 속성 추가 : 톰켓 서버에 데이터 저장
				session.setMaxInactiveInterval(60*30); // 30분 제한
			//HTTP 응답
				resp.setContentType("application/json");
				resp.getWriter().print(loginMno);
			}
	} // post end
	
	// logout
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
		// 유효성 검사
		
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
