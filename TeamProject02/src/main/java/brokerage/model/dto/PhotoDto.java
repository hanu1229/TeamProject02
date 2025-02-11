package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class PhotoDto {
	// 사진번호 PK
	private int phno;
	// 사진이름
	private String phname;
	// 매물번호 FK
	private int pno;
} // c end
