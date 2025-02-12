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


@WebServlet("/member/info")
public class MemberInfoController extends HttpServlet{
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HTTP 요청
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println(memberDto);
		//데이터 유효성 검사
				
		//Dao 데이터 전달 후 응답 받기
		boolean result = false;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object != null) {
			int loginMno = (Integer)object;
			memberDto.setMno(loginMno);// 조회된 로그인된 회원번호를 dto에 넣어준다
			result = MemberDao.getInstance().update(memberDto);
		}//if end
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
} // c end
