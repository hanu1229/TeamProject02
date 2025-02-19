package brokerage.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import brokerage.model.dao.MemberDao;
import brokerage.model.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/afiliado/info")
public class MemberInfoController extends HttpServlet{
	// 회원 정보 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HTTP 요청
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println(memberDto);
		//데이터 유효성 검사
		if(!validationUpdate(memberDto)) {
			resp.getWriter().print("회원 정보 수정 실패");
			return;
		}
		
		//Dao 데이터 전달 후 응답 받기
		boolean result = false;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object != null) {
			int loginMno = (Integer)object;
			memberDto.setMno(loginMno);// 조회된 로그인된 회원번호를 dto에 넣어준다
			result = MemberDao.getInstance().update(memberDto);
		}//if end
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // doPut end
	
	// 회원 정보 수정 유효성 검사 메소드
	private boolean validationUpdate(MemberDto memberDto) {
		// 1. 비밀번호가 비어있거나(null) 6자 미만이면 유효하지 않음
		if(memberDto.getMpwd() == null || memberDto.getMpwd().length() < 6) {
			return false;
		}
		// 2. 이름이 비어있거나(null) 공백만 포함되어 있으면 유효하지 않음
		if(memberDto.getMname() == null || memberDto.getMname().trim().isEmpty()) {
			return false;
		}
		// 3. 전화번호가 null이거나 숫자로만 이루어진 11자리 형식이 아니면 유효하지 않음
		if(memberDto.getMphone() == null || memberDto.getMphone().matches("^\\d{11}$")) {
			return false;
		}
		return true; // 1,2,3 을 통과하면 유효하다고 판단 true 반환
	} //f end
	
	// 로그인 정보 가져오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // 1. 세션 객체 가져오기
	    HttpSession session = req.getSession();
	    
	    // 2. 세션에서 "loginMno" 속성 값 가져오기
	    Object object = session.getAttribute("loginMno");

	    // 3. 만약 세션에 값이 있으면 Integer로 변환, 없으면 null
	    Integer loginMno = (object != null) ? (Integer) object : null;

	    // 4. JSON 변환 (숫자 또는 null 값)
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonResult = mapper.writeValueAsString(loginMno);

	    // 5. 응답 설정 (JSON 형식으로 반환)
	    resp.setContentType("application/json");
	    resp.getWriter().print(jsonResult);
	}
	
	// logout
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션 객체 불러오기
	    HttpSession session = req.getSession();
	    // Dao 전달 => 응답
	    Object object = session.getAttribute("loginMno"); // 세션 속성값 불러오기
	    boolean logOut = false;
	    if(object != null) {// 속성값이 존재하면 속성값 제거 (로그아웃)
	    	session.removeAttribute("loginMno");
	        logOut = true;
	    } // if end
	    resp.setContentType("application/json");
	    resp.getWriter().print(logOut); 
	   } // f end

	
} // c end
