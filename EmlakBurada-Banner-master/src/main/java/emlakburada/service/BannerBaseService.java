package emlakburada.service;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.model.Banner;

public class BannerBaseService {
	protected BannerResponse convertToBannerResponse(Banner banner) {
		BannerResponse response = new BannerResponse();
		response.setId(banner.getId());
		response.setAdvertNo(banner.getAdvertNo());
		response.setPhone(banner.getPhone());
		response.setTotal(banner.getTotal());
		response.setProvince(banner.getProvince());
		response.setDistrict(banner.getDistrict());
		response.setAddresDesc(banner.getAddresDesc());
		return response;
	}

	protected Banner convertToBanner(BannerRequest request) {
		Banner banner = new Banner();
		banner.setId(request.getId());
		banner.setAdvertNo(request.getAdvertNo());
		banner.setPhone(request.getPhone());
		banner.setTotal(request.getTotal());
		banner.setProvince(request.getProvince());
		banner.setDistrict(request.getDistrict());
		banner.setAddresDesc(request.getAddresDesc());
		return banner;
	}

}
