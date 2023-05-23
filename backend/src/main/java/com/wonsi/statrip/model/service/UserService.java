package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.dto.response.LoginResDto;

import java.util.List;

public interface UserService {
	UserDto findUserByUserId(String userId) throws Exception;
	LoginResDto login(UserDto userDto) throws Exception;
	void join(UserDto userDto) throws Exception;
    void logout(String userId) throws Exception;

	void follow(String followerId, String followingId) throws Exception;

	List<UserDto> followingList(String userId) throws Exception;

	List<UserDto> followerList(String userId) throws Exception;
	Boolean isPossible(String userId) throws Exception;
}
