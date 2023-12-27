package com.example.parkview.service.ifs;

import com.example.parkview.entity.Restaurant;
import com.example.parkview.vo.RestaurantServiceReq;
import com.example.parkview.vo.RestaurantServiceRes;

public interface RestaurantService {
	
	public RestaurantServiceRes create(Restaurant restaurant);
	
	public RestaurantServiceRes searchTwoCondetion(String name, String region );
	
	public RestaurantServiceRes searchThreeCondetion(String name, String region, boolean published);
	
	public RestaurantServiceRes searchAll();
	
	public RestaurantServiceRes update(RestaurantServiceReq req);
	
	public RestaurantServiceRes deleteRestaurant(String name);



}
