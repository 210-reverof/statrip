package com.wonsi.statrip.model.repository;

import org.apache.ibatis.annotations.Mapper;

import com.wonsi.statrip.model.dto.UserDto;

import java.util.List;

@Mapper
public interface UserRepository {
	UserDto findUserByUserId(String userId) throws Exception;
	UserDto login(UserDto userDto);
	void setToken(String userId, String refreshToken);
	void join(UserDto userDto);

    void logout(String userId);

	void follow(String followerId, String followingId);
	void unFollow(String followerId, String followingId);

	List<UserDto> followingList(String userId);

	List<UserDto> followerList(String userId);
}
