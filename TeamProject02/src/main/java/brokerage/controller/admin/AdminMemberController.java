package brokerage.controller.admin;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminMemberDao;
import brokerage.model.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/member")
public class AdminMemberController extends HttpServlet {

	/** 회원목록 전체 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminMemberController 회원목록 전체 조회(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<MemberDto> result = AdminMemberDao.getInstance().findAll();
		System.out.println(">> result : " + result);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		
		System.out.println(">> AdminMemberController 회원목록 전체 조회(doGet) 종료\n");
	}
	
	/** 회원 판매권한 수정 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminMemberController 회원목록 개별 수정(doPUT) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println("updateMsell memberDto : " + memberDto.toString());
		boolean updateResult = AdminMemberDao.getInstance().updateMsell(memberDto);
		MemberDto findResult = null;
		if(updateResult == true) {
			findResult = AdminMemberDao.getInstance().find(memberDto);
			System.out.println("findResult memberDto : " + findResult.toString());
		}
		String jsonResult = mapper.writeValueAsString(findResult);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> AdminMemberController 회원목록 개별 수정(doPUT) 종료\n");
	}
	
}
