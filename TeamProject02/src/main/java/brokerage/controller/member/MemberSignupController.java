
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

@WebServlet("/afiliado/signup")
public class MemberSignupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("signup post OK");
		
		// 1. HTTP 요청에서 JSON 데이터를 읽어와 객체로 변환
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println("memberDto : " + memberDto); // 변환된 데이터 확인 로그

		
        // 유효성 검사 수행 (입력 값이 적절한지 확인)
		// ( 0 / 1 / 2 / 3 ) 해서 0 은 회원 가입 성공 1 은 회원 가입 실패 2 / 3 는 유효성 검사 성공 / 실패로 전달?
		
        String validationError = validation(memberDto);
        if (validationError != null) { // 유효성 검사에서 오류가 발생하면
            sendJsonResponse(resp, false, validationError); // 클라이언트에게 실패 메시지 반환
            return; // 회원가입 로직을 실행하지 않고 메서드 종료
        }
        
        // 3. 회원가입 로직 실행 (DB에 회원 정보 저장)
		int signupResult = MemberDao.getInstance().signup(memberDto);
		boolean result = (signupResult > 0); // 회원가입 성공 여부를 boolean으로 변환 // 0보다 크면 성공 (회원번호가 생성됨)
		
		  // 4. JSON 형식으로 회원가입 결과 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
    /**
     * 유효성 검사 메서드
     * 회원가입 입력 값이 올바른지 확인하고, 잘못된 경우 오류 메시지를 반환한다.
     * 모든 값이 정상적이면 null을 반환 (유효성 검사 통과)
     */
    private String validation(MemberDto memberDto) {
        if (memberDto == null) return "회원 정보가 없습니다."; // 요청 데이터가 없는 경우

        // 아이디 유효성 검사 (영문 + 숫자 조합, 5~30자)
        if (memberDto.getMid() == null || !memberDto.getMid().matches("^[a-zA-Z0-9]{5,30}$")) {
            return "아이디는 영문자와 숫자로 이루어진 5~30자의 문자열이어야 합니다!";
        }

        // 비밀번호 유효성 검사 (최소 8자, 대소문자 + 숫자 + 특수문자 포함)
//        if (memberDto.getMpwd() == null || !memberDto.getMpwd().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
//            return "비밀번호는 최소 8자이며, 대소문자, 숫자, 특수문자를 포함해야 합니다!";
//        }

        // 이름 유효성 검사 (한글 또는 영문, 2~15자)
        if (memberDto.getMname() == null || !memberDto.getMname().matches("^[가-힣a-zA-Z]{2,15}$")) {
            return "이름은 한글 또는 영문으로 2~15자여야 합니다!";
        }

//        // 전화번호 유효성 검사 (000-0000-0000 또는 000-000-0000 형식)
//        if (memberDto.getMphone() == null || !memberDto.getMphone().matches("^\\d{3}-\\d{3,4}-\\d{4}$")) {
//            return "전화번호 형식이 올바르지 않습니다! 예: 010-1234-5678";
//        }
        
        // 전화번호 유효성 검사 (하이픈 없이 숫자 13자리만 허용)
        if (memberDto.getMphone() == null || !memberDto.getMphone().matches("^\\d{11}$")) {
            return "전화번호는 ( - ) 제외 숫자 11자리여야 합니다. EX) 0101234567890";
        }

        return null; // 모든 검사를 통과하면 null 반환 (오류 없음)
    }

	  /**
     * JSON 응답을 클라이언트에게 보내는 메서드
     * success: 요청이 성공(true) 또는 실패(false) 여부
     * message: 처리 결과 메시지
     */
    private void sendJsonResponse(HttpServletResponse resp, boolean success, String message) throws IOException {
        resp.setContentType("application/json"); // 응답을 JSON 형식으로 설정
        resp.setCharacterEncoding("UTF-8"); // UTF-8 인코딩 설정 (한글 깨짐 방지)
        
        // JSON 형태로 응답 반환 {"success": true/false, "message": "메시지 내용"}
        resp.getWriter().print("{\"success\": " + success + ", \"message\": \"" + message + "\"}");
    }
}
