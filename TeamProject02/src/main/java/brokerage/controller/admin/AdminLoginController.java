package brokerage.controller.admin;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.AdminLoginDao;
import brokerage.model.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/member")
public class AdminLoginController extends HttpServlet {
	
	/** 관리자 로그인 함수 */ 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminLoginController 관리자 로그인(doPost) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		// js에서 가져온 json값을 MemberDto로 변환(매핑)
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		// 로그인 시도
		MemberDto result = AdminLoginDao.getInstance().Login(memberDto);
		System.out.println(">> result : " + result.toString());
		int mno = 0;
		// 데이터베이스에서 가져온 mno값이 0보다 크면 mno에 mno값 저장 0보다 작거나 같으면 mno에 0 저장
		if(result.getMno() > 0) {
			mno = result.getMno();
		} else {
			mno = 0;
		}
		System.out.println(">> mno : " + mno);
		// 판매권한이 9이면 관리자를 뜻함
		if(result.getMsell() == 9) {
			HttpSession session = req.getSession();
			// 톰캣 세션에 key : adminLoginMno, value : mno로 값을 저장
			session.setAttribute("adminLoginMno", mno);
			// 값이 제대로 저장되어있는지 확인
			System.out.println(">> adminLoginMno : " + session.getAttribute("adminLoginMno"));
		}
		resp.setContentType("application/json");
		resp.getWriter().print(mno);
		
		System.out.println(">> AdminLoginController 관리자 로그인(doPost) 종료\n");
	}
	
}
