package com.example.parkview.vo;

import java.util.List;

import com.example.parkview.constants.RestaurantRtnCode;
import com.example.parkview.entity.Restaurant;


public class RestaurantServiceRes {

	private RestaurantRtnCode restaurantRtnCode;

	private Restaurant restaurant;

	private List<Restaurant> restaurantList;

	public RestaurantServiceRes(RestaurantRtnCode restaurantRtnCode, List<Restaurant> restaurantList) {
		super();
		this.restaurantRtnCode = restaurantRtnCode;
		this.restaurantList = restaurantList;
	}

	public RestaurantServiceRes(RestaurantRtnCode restaurantRtnCode, Restaurant restaurant) {
		super();
		this.restaurantRtnCode = restaurantRtnCode;
		this.restaurant = restaurant;
	}

	public RestaurantServiceRes(RestaurantRtnCode restaurantRtnCode) {
		super();
		this.restaurantRtnCode = restaurantRtnCode;
	}

	public RestaurantRtnCode getRestaurantRtnCode() {
		return restaurantRtnCode;
	}

	public void setRestaurantRtnCode(RestaurantRtnCode restaurantRtnCode) {
		this.restaurantRtnCode = restaurantRtnCode;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

}
