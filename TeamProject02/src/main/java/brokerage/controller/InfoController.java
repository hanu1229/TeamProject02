package brokerage.controller;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/client/info")
public class InfoController extends HttpServlet { //진석만듬

	private ClientService clientService = ClientService.getInstance();
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		try {
			//1.http body의 json 읽기
			Map<String, Integer>jsonData = mapper.readValue(req.getInputStream(),Map.class);
			
			//2.매개변수 추출
			int pno = jsonData.get("pno");
			int mno = jsonData.get("mno");
			
			//3.서비스 메소드 호출
			Map<String, Object>result = clientService.inquireProperty(pno, mno);
			
			//4.응답생성
			
			String jsonResult = mapper.writeValueAsString(result);
			resp.getWriter().print(jsonResult);
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			resp.getWriter().print(e.getMessage());
		}
		}// post end
	
}// class end
