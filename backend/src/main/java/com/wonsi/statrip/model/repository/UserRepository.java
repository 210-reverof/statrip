package com.wonsi.statrip.model.repository;

import org.apache.ibatis.annotations.Mapper;

import com.wonsi.statrip.model.dto.UserDto;

@Mapper
public interface UserRepository {
	String findUserByRefreshToken(String refreshToken) throws Exception;
	UserDto findUserByUserId(String userId) throws Exception;
	UserDto login(UserDto userDto);
	void setToken(String userId, String refreshToken);
}
