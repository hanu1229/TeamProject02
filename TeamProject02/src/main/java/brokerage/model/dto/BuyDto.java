package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class BuyDto {
	// 신청번호 PK
	private int brno;
	// 매물번호 FK
	private int pno;
	// 회원번호 FK
	private int mno;
} // c end