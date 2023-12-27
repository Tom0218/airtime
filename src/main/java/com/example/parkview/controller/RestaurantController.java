package com.example.parkview.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkview.entity.Restaurant;
import com.example.parkview.service.ifs.RestaurantService;
import com.example.parkview.vo.RestaurantServiceReq;
import com.example.parkview.vo.RestaurantServiceRes;

@RestController
@CrossOrigin // 串前端
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@PostMapping(value = "api/park/createRest")
	public RestaurantServiceRes create(@RequestBody Restaurant restaurant) {
		String base64String = restaurant.getPhotoBase64();
		// 將base64字串解碼為字節數組

		byte[] imageBytes = Base64.getDecoder().decode(base64String.split(",")[1]);
		System.err.println("imageBytes:" + imageBytes);
		restaurant.setPhoto(imageBytes);
		restaurant.setPhotoBase64("");
		return service.create(restaurant);
	}

	@GetMapping(value = "api/park/searchThreeConditionRestaurant")
	public RestaurantServiceRes searchThreeConditionRestaurant(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "region", required = false) String region,
			@RequestParam(value = "published", required = false) boolean published) {
		name = StringUtils.hasText(name) ? name : "";
		region = StringUtils.hasText(region) ? region : "";
		return service.searchThreeCondetion(name, region, published);

	}

	@GetMapping(value = "api/park/searchTwoConditionRestaurant")
	public RestaurantServiceRes searchTwoConditionRestaurant(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "region", required = false) String region) {
		name = StringUtils.hasText(name) ? name : "";
		region = StringUtils.hasText(region) ? region : "";
		return service.searchTwoCondetion(name, region);
	}

	@GetMapping(value = "api/park/searchAllRest")
	public RestaurantServiceRes searchAll() {
		return service.searchAll();

	}

	@PostMapping(value = "api/park/updateRestaurant")
	public RestaurantServiceRes update(@RequestBody RestaurantServiceReq req) {
		return service.update(req);
	}
	
	@PostMapping(value = "api/park/deleteRestaurant")
	public RestaurantServiceRes deleteRestaurant(@RequestParam String name  ) {
		System.out.println(name);
		return service.deleteRestaurant(name);
	}

}
