package com.wonsi.statrip.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDto {
	private String userId;
	private String password;
	private String name;
	private String email;
	private int gender; 	// 0:남   1:여
	private int ageGroup; 	// 1:10대   2:20대 ~
	private int addrGroup;	// 0:서울		1:인천경기   2:강원    3:대전충남    4:충북   5:광주전남   6:전북    7:부산경남    8.대구경북
	private String refreshToken;
	private int type1;
	private int type2;
	
	public UserDto toUserDto() {
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setPassword(password);
        userDto.setName(name);
        userDto.setEmail(email);
        userDto.setGender(gender);
        userDto.setAgeGroup(ageGroup);
        userDto.setAddrGroup(addrGroup);
        userDto.setRefreshToken(refreshToken);
        return userDto;
    }

	public JoinDto(String userId, String password, String name, String email, int gender, int ageGroup, int addrGroup,
			String refreshToken, int type1, int type2) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.addrGroup = addrGroup;
		this.refreshToken = refreshToken;
		this.type1 = type1;
		this.type2 = type2;
	}

	public JoinDto() {}
}
