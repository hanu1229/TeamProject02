package brokerage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class ChatBotDto {
	 private String message;    // 사용자 메시지
	    private String response;   // 챗봇 응답
	    private String status;   // 상태
	    
	    
}
