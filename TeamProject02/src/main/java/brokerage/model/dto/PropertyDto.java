package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class PropertyDto {
	// 매물번호 PK
	private int pno;
	// 카테고리
	private int pcategory;
	// 소재지(주소)
	private String paddress;
	// 지도(위도)
	private double plat;
	// 지도(경도)
	private double plong;
	// 동
	private int pbuilding;
	// 층수
	private int pstorey;
	// 면적
	private double parea;
	// 준공년도
	private String pyear;
	// 구조
	private String pstructure;
	// 등기부상 소유권 대상
	private String puser;
	// 추가내용
	private String padd;
	// 등록일
	private String pdate;
	// 판매상태
	private int psell;
	// 회원번호 FK
	private int mno;
} // c end
