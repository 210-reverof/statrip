package com.wonsi.statrip.model.repository;

import org.apache.ibatis.annotations.Mapper;

import com.wonsi.statrip.model.dto.UserDto;

@Mapper
public interface UserRepository {
	String findUserByRefreshToken(String refreshtoken) throws Exception;
	UserDto findUserByUserId(String userId) throws Exception;
}
