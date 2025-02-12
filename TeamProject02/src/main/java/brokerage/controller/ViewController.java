package brokerage.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/client/view")
public class ViewController extends HttpServlet { //진석작성
 
	private ClientService clientService = ClientService.getInstance();
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("application/json");
		
			try {
				
				
				
				
			}catch (Exception e) {
				
			}
	
	}
	
	
}// class end

