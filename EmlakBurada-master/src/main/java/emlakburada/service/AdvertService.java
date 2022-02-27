package emlakburada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.client.BannerFeignClient;
import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.queue.QueueService;
import emlakburada.repository.AdvertRepository;
import emlakburada.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdvertService extends AdvertBaseService {

	@Autowired
	private AdvertRepository advertRepository;

	@Autowired
	private BannerFeignClient bannerFeignClient;

	@Autowired
	private QueueService queueService;

	public List<AdvertResponse> getAllAdverts() {
		List<AdvertResponse> advertList = new ArrayList<>();
		for (Advert advert : advertRepository.findAll()) {
			advertList.add(convertToAdvertResponse(advert));
		}
		return advertList;
	}

	public AdvertResponse saveAdvert(AdvertRequest request) {

		Advert advert = convertToAdvert(request);
		Advert savedAdvert = advertRepository.save(advert);
		//EmailMessage emailMessage = new EmailMessage("kaganince11@gmail.com");
		//queueService.sendMessage(emailMessage);
		bannerFeignClient.saveBanner(prepareSaveBannerRequest(advert));
		return convertToAdvertResponse(savedAdvert);
		
	}

	public AdvertResponse getAdvertByAdvertId(int advertId) {
		Optional<Advert> advert = advertRepository.findById(advertId);
		return convertToAdvertResponse(advert.get());
	}
	
	public void deleteById(int id) {
		advertRepository.deleteById(id);
	}
}
