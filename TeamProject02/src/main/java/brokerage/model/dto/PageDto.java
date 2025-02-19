package brokerage.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class PageDto {
	private int totalPage;          // 전체 페이지 수
	private int currentPage;        // 현재 페이지
	private int startbtn;			// 버튼 시작번호
	private int endbtn;				// 버튼 끝번호
	private List<PropertyDto> properties;  // 매물 목록
	private Object data;	// 페이징된 자료
	
}
