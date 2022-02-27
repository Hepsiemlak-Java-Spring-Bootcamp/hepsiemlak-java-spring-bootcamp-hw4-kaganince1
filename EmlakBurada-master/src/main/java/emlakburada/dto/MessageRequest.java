package emlakburada.dto;

import lombok.Data;

@Data
public class MessageRequest {
	
	private Integer id;
	private String baslik;
	private String icerigi;
	private boolean gorulduMu;
	
}
