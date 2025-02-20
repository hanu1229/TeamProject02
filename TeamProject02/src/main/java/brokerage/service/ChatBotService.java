package brokerage.service;

import java.util.List;

import brokerage.model.dao.PropertyDao;
import brokerage.model.dto.PropertyDto;

public class ChatBotService {
	
	 public PropertyDao propertydao = new PropertyDao();

	    public String processQuery(String userInput) {
	        // 사용자 입력에서 키워드 추출
	        String location = extractLocation(userInput);
	        int maxPrice = extractPrice(userInput);
	        
	        // 검색 조건에 따라 매물 검색
	        List<PropertyDto> properties;
	        if (location != null) {
	            properties = propertydao.searchByLocation(location, maxPrice);
	        } else {
	            properties = propertydao.searchByPrice(0, maxPrice);
	        }
	        
	        return formatResponse(properties);
	    }
	    
	    private String extractLocation(String input) {
	        String[] locations = {"부평구", "계양구", "남동구", "서구"};
	        for (String loc : locations) {
	            if (input.contains(loc)) return loc;
	        }
	        return null;
	    }
	    
	    private int extractPrice(String input) {
	        // 가격 추출 로직 (예: "3억", "2억5천" 등의 텍스트에서 숫자 추출)
	        if (input.contains("억")) {
	            try {
	                String priceText = input.replaceAll("[^0-9]", "");
	                return Integer.parseInt(priceText) * 10000;
	            } catch (Exception e) {
	                return 50000; // 기본값 5억
	            }
	        }
	        return 50000;
	    }
	    
	    private String formatResponse(List<PropertyDto> properties) {
	        if (properties.isEmpty()) {
	            return "죄송합니다. 조건에 맞는 매물을 찾지 못했습니다.";
	        }
	        
	        StringBuilder response = new StringBuilder("다음과 같은 매물을 찾았습니다:\n\n");
	        for (PropertyDto p : properties) {
	            response.append(String.format("- %s(%s)\n", 
	                p.getPaddress(),
	                p.getPcategory()));
	            response.append(String.format("  면적: %.2f㎡, 가격: %d만원\n", 
	                p.getParea(),
	                p.getMprice()));
	            if (p.getPadd() != null && !p.getPadd().isEmpty()) {
	                response.append(String.format("  특징: %s\n", p.getPadd()));
	            }
	            response.append("\n");
	        }
	        return response.toString();
	    }
}
