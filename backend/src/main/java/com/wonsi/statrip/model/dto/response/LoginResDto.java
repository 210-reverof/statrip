package com.wonsi.statrip.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResDto {
	private String refreshToken;
	private String accessToken;
	
	public LoginResDto() {}

	public LoginResDto(String refreshToken, String accessToken) {
		super();
		this.refreshToken = refreshToken;
		this.accessToken = accessToken;
	}

}
