package com.wonsi.statrip.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private String userId;
	private String password;
	private String name;
	private String email;
	private int gender; 	// 0:남   1:여
	private int ageGroup; 	// 1:10대   2:20대 ~
	private int addrGroup;	// 0:서울		1:인천경기   2:강원    3:대전충남    4:충북   5:광주전남   6:전북    7:부산경남    8.대구경북
	
	public UserDto() {}
	
	public UserDto(String userId, String password, String name, String email, int gender, int ageGroup, int addrGroup) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.addrGroup = addrGroup;
	}
}
