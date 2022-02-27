package emlakburada.service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;

public class MessageBaseService {
	protected Message convertToAdvert(MessageRequest messageRequest) {
		Message message = new Message();
		message.setId(messageRequest.getId());
		message.setBaslik(messageRequest.getBaslik());
		message.setIcerigi(messageRequest.getIcerigi());
		message.setGorulduMu(false);
		return message;
	}

	protected MessageResponse convertToMessageResponse(Message message) {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setId(message.getId());
		messageResponse.setBaslik(message.getBaslik());
		messageResponse.setIcerigi(message.getIcerigi());
		messageResponse.setAlici(message.getAlici());
		messageResponse.setGonderici(message.getGonderici());
		return messageResponse;
	}
}
