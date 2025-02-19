package brokerage.controller;

import java.io.IOException;


import java.util.List;



import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.ClientDao;
import brokerage.model.dto.BrokerageDto;
import brokerage.model.dto.PropertyDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/client/view")
public class ViewController extends HttpServlet { //진석작성
 
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<PropertyDto> result = ClientDao.getInstance().findAllProperties();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper obj = new ObjectMapper();
			BrokerageDto brokerageDto = obj.readValue(req.getReader(),BrokerageDto.class);
			brokerageDto.setBfile("brokerage_파일.pdf");
			brokerageDto.setBmanager("김철수");
			HttpSession session = req.getSession();
			int mno = (Integer)session.getAttribute("loginMno");
			brokerageDto.setMno(mno);
			boolean result = ClientDao.getInstance().buy(brokerageDto);
			resp.setContentType("application/json");
			resp.getWriter().print(result);
			
		}
	
}// class end

//기존 전체목록조회(페이징)
//
////pno 파라미터가 없으면 전체 목록 조회
//if(pnoStr ==null) {
//	String pageStr = req.getParameter("page");
//	int page =(pageStr!=null)?Integer.parseInt(pageStr):1;
//	
//	PageDto pageDto = clientService.getPropertyList(page);
//	String jsonResult = mapper.writeValueAsString(pageDto);
//	resp.getWriter().print(jsonResult);
//}
