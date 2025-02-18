package brokerage.controller.estate;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.EstateDao;
import brokerage.model.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/estate/change")
public class ChangeController extends HttpServlet{

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션에서 회원번호 가져오기
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue( req.getReader(), MemberDto.class);
		System.out.println( memberDto );
		// DAO에게 데이터 전달 하고 응답 받기
		boolean result = false;
		HttpSession session = req.getSession(); // 세션 가져오기
		Object object = session.getAttribute("loginMno"); // 세션 객체내 지정한 속성값 가져오기.
		// 만약에 세선객체내 지정한 속성값이 존재하면 로그인회원번호를 타입변환
		if( object != null ) {
			int loginMno = (Integer)object;
			memberDto.setMno(loginMno);
			// DAO에서 판매권한 상태를 3으로 업데이트
			result = EstateDao.getInstance().esellUpdate(memberDto);
		} // if end
		// 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
} // c end
