package com.example.parkview.vo;

import java.time.LocalDate;

import com.example.parkview.entity.Restaurant;


public class RestaurantServiceReq extends Restaurant {

	private Restaurant restaurant;

	private String name;

	private String newName;

	private String description;

	private String region;

	private LocalDate startDate;

	private LocalDate endDate;

	private boolean published;

	private byte[] photo;

	private String photoBase64;

	public RestaurantServiceReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantServiceReq(String name, String region, boolean published) {
		super();
		this.name = name;
		this.region = region;
		this.published = published;
	}

	public RestaurantServiceReq(String name, String region) {
		super();
		this.name = name;
		this.region = region;
	}

	public RestaurantServiceReq(String name, String newName, String description, String region, LocalDate startDate,
			LocalDate endDate, boolean published, byte[] photo, String photoBase64) {
		super();
		this.name = name;
		this.newName = newName;
		this.description = description;
		this.region = region;
		this.startDate = startDate;
		this.endDate = endDate;
		this.published = published;
		this.photo = photo;
		this.photoBase64 = photoBase64;
	}

	public RestaurantServiceReq(String name, String description, String region, LocalDate startDate, LocalDate endDate,
			boolean published, byte[] photo, String photoBase64) {
		super();
		this.name = name;
		this.description = description;
		this.region = region;
		this.startDate = startDate;
		this.endDate = endDate;
		this.published = published;
		this.photo = photo;
		this.photoBase64 = photoBase64;
	}

	public RestaurantServiceReq(String name, String newName, String description, String region, LocalDate startDate,
			LocalDate endDate, boolean published) {
		super();
		this.name = name;
		this.newName = newName;
		this.description = description;
		this.region = region;
		this.startDate = startDate;
		this.endDate = endDate;
		this.published = published;
	}

	public RestaurantServiceReq(String name, String description, String region, LocalDate startDate, LocalDate endDate,
			boolean published) {
		super();
		this.name = name;
		this.description = description;
		this.region = region;
		this.startDate = startDate;
		this.endDate = endDate;
		this.published = published;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
