package brokerage.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminBrokerageDao;
import brokerage.model.dto.BrokerageDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/brokerage")
public class AdminBrokerage extends HttpServlet {

	/** 중개한 매물 전체 출력 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminBrokerage 중개한 매물 전체 출력(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<BrokerageDto> result = AdminBrokerageDao.getInstance().findAll();
		System.out.println(">> result : " + result);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> AdminBrokerage 중개한 매물 전체 출력(doGet) 종료\n");
	}
	
}
