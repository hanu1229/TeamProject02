package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class BrokerageDto {
	// 중개번호 PK
	private int bno;
	// 파일명
	private String bfile;
	// 승인날짜
	private String bdate;
	// 담당자
	private String bmanager;
	// 추가내용
	private String bcomment;
	// 회원번호 FK
	private int mno;
	// 매물번호 FK
	private int pno;
} // c end
