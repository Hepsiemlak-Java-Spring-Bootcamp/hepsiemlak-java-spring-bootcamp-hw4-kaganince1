package emlakburada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;

@Service
public class MessageService extends MessageBaseService{
	
	@Autowired
	private MessageRepository messageRepository;
	
	private static Long messageId = 4L;
	
	public List<MessageResponse> getAllMessages() {
		List<MessageResponse> messageResponseList = new ArrayList<>();
		for(Message message : messageRepository.findAll()) {
			messageResponseList.add(convertToMessageResponse(message));
		}
		return messageResponseList;
	}
	
	public MessageResponse getMessageById(Integer id) {
		Optional<Message> message = messageRepository.findById(id);
		return convertToMessageResponse(message.get());
	}
	
	public MessageResponse saveMessage(MessageRequest messageRequest) {
		Message savedMessage = messageRepository.save(convertToAdvert(messageRequest));
		return convertToMessageResponse(savedMessage);
	}
	
	public void deleteById(Integer id) {
		messageRepository.deleteById(id);
	}
}
