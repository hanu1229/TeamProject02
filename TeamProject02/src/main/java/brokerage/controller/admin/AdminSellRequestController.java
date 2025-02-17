package brokerage.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminSellRequestDao;
import brokerage.model.dto.SellDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/sell")
public class AdminSellRequestController extends HttpServlet {
	
	/** 신청한 매물 전체 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminSellRequest 신청한 매물 전체 조회(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<SellDto> result = AdminSellRequestDao.getInstance().findAll();
		System.out.println(">> result : " + result);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> AdminSellRequest 신청한 매물 전체 조회(doGet) 종료\n");
	}
	
}
