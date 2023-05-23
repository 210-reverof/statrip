package com.wonsi.statrip.model.repository;

import org.apache.ibatis.annotations.Mapper;

import com.wonsi.statrip.model.dto.UserDto;

import java.util.List;

@Mapper
public interface UserRepository {
	UserDto findUserByUserId(String userId) throws Exception;
	UserDto login(UserDto userDto) throws Exception;
	void setToken(String userId, String refreshToken) throws Exception;
	void join(UserDto userDto) throws Exception;
	void addUserType(String userId, int typeId, int cnt) throws Exception;

    void logout(String userId) throws Exception;

	void follow(String followerId, String followingId) throws Exception;
	void unFollow(String followerId, String followingId) throws Exception;

	List<UserDto> followingList(String userId) throws Exception;

	List<UserDto> followerList(String userId) throws Exception;

	List<String> userList() throws Exception;
	
	String isPossible(String userId) throws Exception;
}
