package brokerage.controller.admin;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminLoginDao;
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
		
		ObjectMapper mapper = new ObjectMapper();
		String mname = null;
		// 기존 세션이 없으면 null 반환
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json");
        if (session != null && session.getAttribute("adminLoginMno") != null) {
            int loginStatus = (int) session.getAttribute("adminLoginMno");
            mname = AdminLoginDao.getInstance().loginCheck(loginStatus);
            mname = mapper.writeValueAsString(mname);
            resp.getWriter().print(mname);
            System.out.println(">> 로그인 번호 : " + loginStatus);
            System.out.println(">> 로그인 이름 : " + mname);
        } else {
        	// 기본값으로 비로그인 상태 반환
            resp.getWriter().print(mname);
            System.out.println(">> 비로그인 : " + 0);
        }
        
		System.out.println(">> AdminCheckController 로그인 상태 체크(doGet) 종료\n");
	}
	
}

