package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.StatDto;
import com.wonsi.statrip.model.dto.response.FollowCntDto;
import com.wonsi.statrip.model.service.JwtService;
import com.wonsi.statrip.model.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.dto.response.LoginResDto;
import com.wonsi.statrip.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody UserDto userDto) throws Exception {
		userService.join(userDto);
		return ResponseEntity.ok("success");
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResDto> login(@RequestBody UserDto userDto) throws Exception {
		return ResponseEntity.ok(userService.login(userDto));	
	}
	
	@GetMapping("/info")
	public ResponseEntity<UserDto> info(HttpServletRequest request) throws Exception {
		String userId = jwtService.getUserId();
		return ResponseEntity.ok(userService.findUserByUserId(userId));
	}

	@GetMapping("/logout/{userId}")
	public ResponseEntity<Void> logout(@PathVariable("userId") String userId) {
		userService.logout(userId);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<Void> refresh(@RequestBody UserDto userDto) throws Exception {		
		return ResponseEntity.ok(null);	
	}

	@PostMapping("/follow/{id}")
	public ResponseEntity<String> follow(HttpServletRequest request, @PathVariable("id") String followingId) {
		String userId = jwtService.getUserId();
		userService.follow(userId, followingId);

		return ResponseEntity.ok("success");
	}

	@GetMapping("/following")
	public ResponseEntity<List<UserDto>> following(HttpServletRequest request) {
		String userId = jwtService.getUserId();
		List<UserDto> followings = userService.followingList(userId);

		return ResponseEntity.ok(followings);
	}

	@GetMapping("/follower")
	public ResponseEntity<List<UserDto>> follower(HttpServletRequest request) {
		String userId = jwtService.getUserId();
		List<UserDto> followers = userService.followerList(userId);

		return ResponseEntity.ok(followers);
	}

	@GetMapping("/follow-cnt")
	public ResponseEntity<FollowCntDto> followCnt(HttpServletRequest request) {
		String userId = jwtService.getUserId();
		FollowCntDto dto = new FollowCntDto();
		dto.setFollowerCnt(userService.followerList(userId).size());
		dto.setFollowingCnt(userService.followingList(userId).size());

		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/follow-user-cnt/{userId}")
	public ResponseEntity<FollowCntDto> followUserCnt(@PathVariable("userId") String userId) {
		FollowCntDto dto = new FollowCntDto();
		dto.setFollowerCnt(userService.followerList(userId).size());
		dto.setFollowingCnt(userService.followingList(userId).size());

		return ResponseEntity.ok(dto);
	}
}