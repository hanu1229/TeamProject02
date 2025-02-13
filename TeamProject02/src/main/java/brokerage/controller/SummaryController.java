package brokerage.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dto.PropertyDto;
import brokerage.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/client/summary") //개별 조회용
public class SummaryController extends HttpServlet { //진석만듬 
	
	private ClientService clientService = ClientService.getInstance();
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("application/json;charset=UTF-8");
			
		try {
			int pno = Integer.parseInt(req.getParameter("pno"));
			PropertyDto property = clientService.getProperty(pno);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			resp.getWriter().print(e.getMessage());
		}
	
	}// get end
	
}// class end
