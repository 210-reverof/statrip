package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.UserDto;

public interface UserService {
	String findUserByRefreshToken(String refreshtoken) throws Exception;
	UserDto findUserByUserId(String userId) throws Exception;

}
