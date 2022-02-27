package emlakburada.service;

import java.util.Optional;

import emlakburada.client.request.BannerRequest;
import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvertBaseService {
	
	protected AdvertResponse convertToAdvertResponse(Advert savedAdvert) {
		AdvertResponse response = new AdvertResponse();
		response.setId(savedAdvert.getId());
		response.setBaslik(savedAdvert.getBaslik());
		response.setFiyat(savedAdvert.getFiyat());
		response.setAdvertNo(savedAdvert.getAdvertNo());
		return response;
	}
	
	protected Advert convertToAdvert(AdvertRequest request) {
		Advert advert = new Advert();
		advert.setId(request.getId());
		advert.setBaslik(request.getBaslik());
		advert.setFiyat(request.getFiyat());
		advert.setSuresi(request.getSuresi());
		return advert;
	}
	
	protected BannerRequest prepareSaveBannerRequest(Advert advert) {
		BannerRequest request = new BannerRequest();
		request.setAdvertNo(advert.getAdvertNo());
		request.setPhone("5555555555");
		request.setTotal(1);
		return request;
	}
}
