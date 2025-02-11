package brokerage.model.dto;

import java.util.List;

public class PageDto {
	private int totalPage;          // 전체 페이지 수
	private int currentPage;        // 현재 페이지
	private List<PropertyDto> properties;  // 매물 목록

}
