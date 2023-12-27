package com.example.parkview.service.Impl;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.parkview.constants.RestaurantRtnCode;
import com.example.parkview.entity.Restaurant;
import com.example.parkview.repository.RestaurantDao;
import com.example.parkview.service.ifs.RestaurantService;
import com.example.parkview.vo.RestaurantServiceReq;
import com.example.parkview.vo.RestaurantServiceRes;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao restaurantDao;

	public RestaurantServiceRes checkParam(Restaurant restaurant) {
		if (!StringUtils.hasText(restaurant.getName()) || !StringUtils.hasText(restaurant.getDescription())
				|| !StringUtils.hasText(restaurant.getRegion()) || restaurant.getStartDate() == null
				|| restaurant.getEndDate() == null) {
			return new RestaurantServiceRes(RestaurantRtnCode.PARAM_ERROR);
		}
		return null;

	}

	@Override
	public RestaurantServiceRes create(Restaurant restaurant) {
		if (restaurant.getPhoto() == null) {
			return new RestaurantServiceRes(RestaurantRtnCode.PARAM_ERROR);
		}
		restaurantDao.save(restaurant);
		return new RestaurantServiceRes(RestaurantRtnCode.SUCCESSFUL);

	}

	@Transactional
	@Override
	public RestaurantServiceRes searchAll() {
		List<Restaurant> restaurantList = restaurantDao.findAll();
		for (Restaurant r : restaurantList) {
			System.out.println("Name:" + r.getName());
		}
		return new RestaurantServiceRes(RestaurantRtnCode.SUCCESSFUL, restaurantList);
	}

	@Transactional
	@Override
	public RestaurantServiceRes searchTwoCondetion(String name, String region) {
		List<Restaurant> restaurantList = restaurantDao.findTwoCondetionRestaurants(name, region);
		if (restaurantList.isEmpty()) {
			return new RestaurantServiceRes(RestaurantRtnCode.RESTAURANT_NOT_FOUND);
		}
		for (Restaurant r : restaurantList) {

		}
		return new RestaurantServiceRes(RestaurantRtnCode.SUCCESSFUL, restaurantList);

	}

	@Transactional
	@Override
	public RestaurantServiceRes searchThreeCondetion(String name, String region, boolean published) {
		List<Restaurant> restaurantList = restaurantDao.findThreeCondetionRestaurants(name, region, published);
		if (restaurantList.isEmpty()) {
			return new RestaurantServiceRes(RestaurantRtnCode.RESTAURANT_NOT_FOUND);
		}
		for (Restaurant r : restaurantList) {
			System.out.println(r.getName());
		}
		return new RestaurantServiceRes(RestaurantRtnCode.SUCCESSFUL, restaurantList);

	}

	@Transactional
	@Override
	public RestaurantServiceRes update(RestaurantServiceReq req) {
		Optional<Restaurant> RestOp = restaurantDao.findById(req.getName());
		if (RestOp.isEmpty()) {
			return new RestaurantServiceRes(RestaurantRtnCode.RESTAURANT_NAME_NOT_FOUND);
		}
		if (StringUtils.hasText(req.getPhotoBase64())) {
			String base64String = req.getPhotoBase64();
			byte[] imageBytes = Base64.getDecoder().decode(base64String.split(",")[1]);
			req.setPhoto(imageBytes);
			req.setPhotoBase64("");
		} else {
			req.setPhoto(RestOp.get().getPhoto());
		}
		if (req.getStartDate().isAfter(req.getEndDate())) {
			return new RestaurantServiceRes(RestaurantRtnCode.TIME_PARAM_ERROR);
		}
		

		if (req.getNewName().equals(req.getName())) {
			Restaurant newRestaurant = new Restaurant(req.getNewName(), req.getDescription(), req.getRegion(),
					req.getStartDate(), req.getEndDate(), req.isPublished(), req.getPhoto(), req.getPhotoBase64());
			restaurantDao.save(newRestaurant);
			return new RestaurantServiceRes(RestaurantRtnCode.UPDATE_SUCCESSFUL);
		}
		Restaurant newRestaurant = new Restaurant(req.getNewName(), req.getDescription(), req.getRegion(),
				req.getStartDate(), req.getEndDate(), req.isPublished(), req.getPhoto(), req.getPhotoBase64());
		restaurantDao.save(newRestaurant);
		restaurantDao.deleteById(req.getName());
		return new RestaurantServiceRes(RestaurantRtnCode.UPDATE_SUCCESSFUL);
	}

	@Transactional
	@CacheEvict(cacheNames = "update", allEntries = true)
	@Override
	public RestaurantServiceRes deleteRestaurant(String name) {
		if (restaurantDao.findById(name).isEmpty()) {
			return new RestaurantServiceRes(RestaurantRtnCode.RESTAURANT_NAME_NOT_FOUND);
		}
		restaurantDao.deleteById(name);
		return new RestaurantServiceRes(RestaurantRtnCode.DELETE_SUCCESSFUL);
	}

}
