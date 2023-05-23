package com.wonsi.statrip.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonsi.statrip.exception.UnAuthorizedException;
import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.dto.response.LoginResDto;
import com.wonsi.statrip.model.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserDto findUserByUserId(String userId) throws Exception {
		return sqlSession.getMapper(UserRepository.class).findUserByUserId(userId);
	}

	@Override
	public LoginResDto login(UserDto userDto) throws Exception {
		UserDto user = sqlSession.getMapper(UserRepository.class).login(userDto);
		if (user == null) throw new UnAuthorizedException("존재하지 않는 사용자입니다.");
		String accessToken = jwtService.createAccessToken("userid", userDto.getUserId());
		String refreshToken = jwtService.createRefreshToken("userid", userDto.getUserId());

		sqlSession.getMapper(UserRepository.class).setToken(userDto.getUserId(), refreshToken);
		return new LoginResDto(accessToken, refreshToken);
	}

	@Override
	public void join(UserDto userDto) throws Exception {
		sqlSession.getMapper(UserRepository.class).join(userDto);
		// TODO:: 초기설문 넣기
		
	}

	@Override
	public void logout(String userId) throws Exception {
		sqlSession.getMapper(UserRepository.class).logout(userId);
	}

	@Override
	public void follow(String followerId, String followingId) throws Exception {
		sqlSession.getMapper(UserRepository.class).follow(followerId, followingId);
	}

	@Override
	public List<UserDto> followingList(String userId) throws Exception {
		return sqlSession.getMapper(UserRepository.class).followingList(userId);
	}

	@Override
	public List<UserDto> followerList(String userId) throws Exception {
		return sqlSession.getMapper(UserRepository.class).followerList(userId);
	}

	@Override
	public Boolean isPossible(String userId) throws Exception {
		String res = sqlSession.getMapper(UserRepository.class).isPossible(userId);
		if (res == null) return true;
		return false;
	}

}
