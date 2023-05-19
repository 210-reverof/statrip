package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.dto.response.LoginResDto;

public interface UserService {
	String findUserByRefreshToken(String refreshToken) throws Exception;
	UserDto findUserByUserId(String userId) throws Exception;
	LoginResDto login(UserDto userDto) throws Exception;

}
