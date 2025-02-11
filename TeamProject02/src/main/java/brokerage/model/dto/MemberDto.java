package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class MemberDto {
	// 회원번호 PK
	private int mno;
	// 회원아이디
	private String mid;
	// 회원비밀번호
	private String mpwd;
	// 회원성명
	private String mname;
	// 회원전화번호
	private String mphone;
	// 가입날짜
	private String mdate;
	// 판매권한 : 0 = 판매 X , 1 = 판매 O , 9 = 관리자
	private int msell;
} // c end
