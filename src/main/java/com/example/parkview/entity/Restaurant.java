package com.example.parkview.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "region")
	private String region;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "published")
	private boolean published;

	@Column(name = "photo")
	private byte[] photo;

	@Column(name = "photo_base64")
	private String photoBase64;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Restaurant(String name, String description, String region, LocalDate startDate, LocalDate endDate,
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

	public Restaurant(String name, String description, String region, LocalDate startDate, LocalDate endDate,
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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
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

}
