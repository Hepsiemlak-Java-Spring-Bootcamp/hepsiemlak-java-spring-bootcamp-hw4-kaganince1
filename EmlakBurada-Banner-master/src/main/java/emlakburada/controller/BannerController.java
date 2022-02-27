package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.service.BannerService;

@RestController
public class BannerController {

	@Autowired
	private BannerService service;

	@GetMapping(value = "/banners")
	public ResponseEntity<List<BannerResponse>> getAllBanners() {
		return new ResponseEntity<>(service.getAllBanners(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/banners/{bannerId}")
	public ResponseEntity<BannerResponse> getBannerById(@PathVariable(required = false) Integer bannerId) {
		return new ResponseEntity<>(service.getBannerById(bannerId), HttpStatus.OK);
	}

	@PostMapping(value = "/banners")
	public ResponseEntity<BannerResponse> saveBanner(@RequestBody BannerRequest request) {
		return new ResponseEntity<>(service.saveBanner(request), HttpStatus.OK);
	}

	@DeleteMapping(value = "/banners/{bannerId}")
	public ResponseEntity<?> deleteById(@PathVariable Integer bannerId) {
		service.deleteById(bannerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
