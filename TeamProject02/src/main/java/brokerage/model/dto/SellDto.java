package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class SellDto {
	// 매물신청번호 PK
	private int sno;
	// 첨부파일
	private String sfile;
	// 신청날짜
	private String sdate;
	// 신청상태
	private int sstate;
	// 추가내용
	private String sadd;
	// 회원번호 FK
	private int mno;
	// 회원이름
	private String mname;
} // c end
