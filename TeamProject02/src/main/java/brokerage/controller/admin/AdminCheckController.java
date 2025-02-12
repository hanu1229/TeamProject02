package brokerage.controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/check")
public class AdminCheckController extends HttpServlet {
	
	/** 로그인 상태 체크 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminCheckController 로그인 상태 체크(doGet) 실행");
		
		System.out.println(">> 실행1");
		boolean result = false;
		

		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> AdminCheckController 로그인 상태 체크(doGet) 종료\n");
	}
	
}
