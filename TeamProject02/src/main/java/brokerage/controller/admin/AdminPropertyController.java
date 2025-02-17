package brokerage.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminPropertyDao;
import brokerage.model.dto.PropertyDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/property")
public class AdminPropertyController extends HttpServlet {

	/** 등록된 매물 전체 출력 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminPropertyController 등록된 매물 전체 출력(doGet) 실행");
		
		int page = Integer.parseInt(req.getParameter("page"));
		System.out.println("page : " + page);
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<PropertyDto> result = AdminPropertyDao.getInstance().findAll(page);
		System.out.println(">> result : " + result);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> AdminPropertyController 등록된 매물 전체 출력(doGet) 종료\n");
	}
	
}
