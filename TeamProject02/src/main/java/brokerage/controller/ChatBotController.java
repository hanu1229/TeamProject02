package brokerage.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import brokerage.service.ChatBotService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/chatbot")
public class ChatBotController extends HttpServlet  {
	 private static final long serialVersionUID = 1L;
	    private ChatBotService chatbotService = new ChatBotService();
	    private ObjectMapper objectMapper = new ObjectMapper();
	
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");
	        
	        try {
	            // Jackson으로 JSON 요청 파싱
	            ObjectNode requestData = objectMapper.readValue(req.getReader(), ObjectNode.class);
	            String userMessage = requestData.get("message").asText();
	            
	            // 챗봇 서비스로 응답 생성
	            String botResponse = chatbotService.processQuery(userMessage);
	            
	            // Jackson으로 JSON 응답 생성
	            ObjectNode jsonResponse = objectMapper.createObjectNode();
	            jsonResponse.put("status", "success");
	            jsonResponse.put("response", botResponse);
	            
	            // 응답 전송
	            objectMapper.writeValue(resp.getWriter(), jsonResponse);
	            
	        } catch (Exception e) {
	            // 에러 발생 시 에러 응답 전송
	            ObjectNode errorResponse = objectMapper.createObjectNode();
	            errorResponse.put("status", "error");
	            errorResponse.put("message", "요청 처리 중 오류가 발생했습니다.");
	            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            objectMapper.writeValue(resp.getWriter(), errorResponse);
	        }
	    }
	}
	    
	    
