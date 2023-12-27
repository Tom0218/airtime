package com.example.parkview.constants;

public enum RestaurantRtnCode {
	
	SUCCESSFUL(200, " Successful !"), //
	UPDATE_SUCCESSFUL(200, " Update successful !"), //
	DELETE_SUCCESSFUL(200, " Delete successful !"), //
	PARAM_ERROR(400," Param error!"),//
	TIME_PARAM_ERROR(400," Time Param error!"),//
	UPDATE_ERROR(400," Update error!"),//
	RESTAURANT_NAME_NOT_FOUND(404," Restaurant name not found!"),//
	RESTAURANT_NOT_FOUND(404," Restaurant  not found!"),//
	;
	
	
	private int permission;
	
	private String title;

	private RestaurantRtnCode(int permission, String title) {
		this.permission = permission;
		this.title = title;
	}

	public int getPermission() {
		return permission;
	}

	public String getTitle() {
		return title;
	

	}
	
	

}
