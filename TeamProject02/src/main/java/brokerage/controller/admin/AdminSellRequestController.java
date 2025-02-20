package brokerage.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.admin.AdminSellRequestDao;
import brokerage.model.dto.PropertyDto;
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
	
	/** 신청 매물 수락 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminSellRequest 신청 매물 수락(doPost) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		PropertyDto propertyDto = mapper.readValue(req.getReader(), PropertyDto.class);
		System.out.println(">> propertyDto : " + propertyDto);
		boolean result = AdminSellRequestDao.getInstance().accept(propertyDto);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> AdminSellRequest 매물 수락(doPost) 종료\n");
	}
	
	/** 신청한 매물 거절 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> AdminSellRequest 신청한 매물 거절(doPut) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		SellDto sellDto = mapper.readValue(req.getReader(), SellDto.class);
		SellDto result = AdminSellRequestDao.getInstance().update(sellDto);
		System.out.println(">> result : " + result);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> AdminSellRequest 신청한 매물 거절(doPut) 종료\n");
	}
	
}
