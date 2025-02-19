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
	
//	// 회원 정보 찾기
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		// JSON 요청을 Java 객체로 변환
//		ObjectMapper mapper = new ObjectMapper();
//		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
//		System.out.println("Received Member Data: " + memberDto);
//		
//		// 데이터 유효성 검사
//		// validateInput() 메서드를 호출하여 입력값의 유효성을 검사
//		// 만약 validateInput()이 false를 반환하면 아래의 에러 응답을 보낸다.
//		if (!validateInput(memberDto)) {
//			 // HTTP 응답으로 JSON 형식의 에러 메시지를 클라이언트에게 보냄
//            resp.getWriter().print("{\"error\": \"Invalid input data\"}");
//            return;   // return을 사용하여 메서드 실행을 중단하고, 더 이상 코드가 실행되지 않도록 함
//        }
//		
//		// DAO를 통해 회원 조회
//		MemberDto foundMember = MemberDao.getInstance().findMember(memberDto);
//		
//		// JSON 응답
//		// foundMember 변수가 null인지 여부를 검사하는 삼항 연산자(조건부 연산자) 사용
//		String jsonResponse = (foundMember != null) ? // foundMember가 null이 아닌 경우 → 찾은 회원 정보를 JSON으로 변환
//				mapper.writeValueAsString(foundMember) : "{\"error\": \"일치하는 회원 정보가 없습니다.\"}"; // foundMember가 null인 경우 → 에러 메시지를 JSON 형식의 문자열로 반환
//		// resp.setContentType("application/json");
//		resp.getWriter().print(jsonResponse);
//	}
//	
//	// 회원 정보 찾기 유효성 검사
//	private boolean validateInput(MemberDto memberDto) {
//		  // 회원 이름(mname)이 null이 아니고, 공백을 제외한 실제 값이 존재하는지 확인
//        return memberDto.getMname() != null  // mname이 null이면 false 반환
//        	&& !memberDto.getMname().trim().isEmpty()  // 공백을 제거한 후에도 값이 없으면 false 반환
//            && memberDto.getMphone() != null // mphone이 null이면 false 반환
//            && !memberDto.getMphone().trim().isEmpty(); // 공백을 제거한 후에도 값이 없으면 false 반환
//    }
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		MemberDto result = null;
//		// 세션 가져오기
//		HttpSession session = req.getSession();
//		// 세션객체 안에서 지정한 속성 값 가져오기
//		Object object = session.getAttribute("loginMno");
//		// 만약에 세션객체 안에 지정한 속성의 값이 있으면 로그인 회원번호 타입변환
//		if( object != null ) {
//			int loginMno = (Integer)object;
//			// 현재 로그인된 회원번호를 매개변수로 전달
//			result = MemberDao.getInstance().myInfo(loginMno);
//		} // if end
//		// 자료 타입 변환
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonResult = mapper.writeValueAsString( result );
//		// 응답 반환
//		resp.setContentType("application/json");
//		resp.getWriter().print( jsonResult );
//		
//	} // f end
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

	
} // c end
