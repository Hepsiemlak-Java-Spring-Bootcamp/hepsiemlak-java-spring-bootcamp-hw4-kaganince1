package emlakburada.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerRequest {
	
	private Integer id;
	private int advertNo;
	private String phone;
	private int total;
	private String province;
	private String district;
	private String addresDesc;

}
