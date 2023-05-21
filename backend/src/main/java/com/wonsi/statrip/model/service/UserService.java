package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.dto.response.LoginResDto;

import java.util.List;

public interface UserService {
	UserDto findUserByUserId(String userId) throws Exception;
	LoginResDto login(UserDto userDto) throws Exception;
	void join(UserDto userDto);
    void logout(String userId);

	void follow(String followerId, String followingId);

	List<UserDto> followingList(String userId);

	List<UserDto> followerList(String userId);
}
