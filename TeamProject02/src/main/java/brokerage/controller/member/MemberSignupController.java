
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

@WebServlet("/member/signup")
public class MemberSignupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("signup post OK");
		
		//HTTP 요청
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println("memberDto : " + memberDto);
		// 유효성 검사
		
		// Dao 전달 => 응답
		int signupResult = MemberDao.getInstance().signup(memberDto);
		boolean result = (signupResult > 0); // 회원가입 성공 여부를 boolean으로 변환

		// HTTP 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	
}
