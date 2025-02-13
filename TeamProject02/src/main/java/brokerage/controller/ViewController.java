package brokerage.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dto.PageDto;
import brokerage.model.dto.PropertyDto;
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
				
			String pnoStr = req.getParameter("pno");
			
			//pno 파라미터가 없으면 전체 목록 조회
			if(pnoStr ==null) {
				String pageStr = req.getParameter("page");
				int page =(pageStr!=null)?Integer.parseInt(pageStr):1;
				
				PageDto pageDto = clientService.getPropertyList(page);
				String jsonResult = mapper.writeValueAsString(pageDto);
				resp.getWriter().print(jsonResult);
			}
				//pno(매물번호) 가 있으면 상세조회
			else {
				int pno = Integer.parseInt(pnoStr);
				PropertyDto property = clientService.getPropertyDetail(pno);
				String jsonResult = mapper.writeValueAsString(property);
				resp.getWriter().print(jsonResult);
				
					
			}
			}catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				resp.getWriter().print(e.getMessage());
			}
	
	}
	
	
}// class end

