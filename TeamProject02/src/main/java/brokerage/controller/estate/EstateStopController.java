package brokerage.controller.estate;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.EstateDao;
import brokerage.model.dto.PropertyDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/estate/stop")
public class EstateStopController extends HttpServlet{

	// 매물 판매 중지 
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EstateStopController doput!!");
	    ObjectMapper mapper = new ObjectMapper();
	    PropertyDto propertyDto = mapper.readValue(req.getReader(), PropertyDto.class);

	    // 클라이언트에서 전달된 값 확인
	    System.out.println("Received pno: " + propertyDto.getPno());

	    boolean result = EstateDao.getInstance().estateStop(propertyDto);
	    resp.setContentType("application/json");
	    resp.getWriter().print(result);
	} // f end
	
} // c end
