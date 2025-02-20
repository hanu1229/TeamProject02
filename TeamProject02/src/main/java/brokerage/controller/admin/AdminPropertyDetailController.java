package brokerage.controller.admin;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminPropertyDao;
import brokerage.model.dto.PropertyDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/property/detail")
public class AdminPropertyDetailController extends HttpServlet {
	
	/** 등록된 매물 상세보기 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminPropertyDetail 등록된 매물 상세보기(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper(); 
		int pno = Integer.parseInt(req.getParameter("pno"));
		System.out.println(">> pno : " + pno);
		PropertyDto result = AdminPropertyDao.getInstance().detail(pno);
		System.out.println(">> result = " + result);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> AdminPropertyDetail 등록된 매물 상세보기(doGet) 종료\n");
	}
	
}
