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
	
	// 유효성 검사 메소드
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
	
} // c end
