package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString

public class MemberDto {
	
	private int mno; // 회원번호
	private String mid; // 아이디
	private String mpwd; // 비번
	private String mname; // 이름
	private String mphone; // 전번
	private String mdate; // 가입일
	private int msell_state; // 판매권한
	// 판매권한 : 0 = 판매 X , 1 = 판매 O , 9 = 관리자
	
}
