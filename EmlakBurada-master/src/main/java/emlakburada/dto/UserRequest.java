package emlakburada.dto;

import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	
	private Integer id;
	private UserType userType;
	private String name;
	private String email;
	private String photo;
	private String bio;

}
