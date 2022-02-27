package emlakburada.dto.response;

import java.util.ArrayList;
import java.util.List;

import emlakburada.model.Advert;
import emlakburada.model.Message;
import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private Integer id;
	private UserType userType; 
	private String name;
	private String email;
	private String photo;
	private String bio;
	private List<Advert> yayinladigiIlanlar = new ArrayList<>();
	private List<Message> receivedMessages;
	
}
