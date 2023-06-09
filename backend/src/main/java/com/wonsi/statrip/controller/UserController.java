package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.dto.JoinDto;
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
	public ResponseEntity<String> join(@RequestBody JoinDto joinDto) throws Exception {
		userService.join(joinDto);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/possible/{userId}")
	public ResponseEntity<Boolean> check(@PathVariable("userId") String userId) throws Exception {
		return ResponseEntity.ok(userService.isPossible(userId));
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
	public ResponseEntity<Void> logout(@PathVariable("userId") String userId) throws Exception {
		userService.logout(userId);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<Void> refresh(@RequestBody UserDto userDto) throws Exception {		
		return ResponseEntity.ok(null);	
	}

	@PostMapping("/follow/{id}")
	public ResponseEntity<String> follow(HttpServletRequest request, @PathVariable("id") String followingId) throws Exception {
		String userId = jwtService.getUserId();
		userService.follow(userId, followingId);

		return ResponseEntity.ok("success");
	}

	@PostMapping("/unfollow/{id}")
	public ResponseEntity<String> unfollow(HttpServletRequest request, @PathVariable("id") String followingId) throws Exception {
		String userId = jwtService.getUserId();
		userService.unfollow(userId, followingId);

		return ResponseEntity.ok("success");
	}

	@GetMapping("/following/{userId}")
	public ResponseEntity<List<UserDto>> following(HttpServletRequest request, @PathVariable("userId") String userId) throws Exception {
		List<UserDto> followings = userService.followingList(userId);

		return ResponseEntity.ok(followings);
	}

	@GetMapping("/follower/{userId}")
	public ResponseEntity<List<UserDto>> follower(HttpServletRequest request, @PathVariable("userId") String userId) throws Exception {
		List<UserDto> followers = userService.followerList(userId);

		return ResponseEntity.ok(followers);
	}

	@GetMapping("/follow-cnt")
	public ResponseEntity<FollowCntDto> followCnt(HttpServletRequest request) throws Exception {
		String userId = jwtService.getUserId();
		FollowCntDto dto = new FollowCntDto();
		dto.setFollowerCnt(userService.followerList(userId).size());
		dto.setFollowingCnt(userService.followingList(userId).size());

		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/follow-user-cnt/{userId}")
	public ResponseEntity<FollowCntDto> followUserCnt(@PathVariable("userId") String userId) throws Exception {
		FollowCntDto dto = new FollowCntDto();
		dto.setFollowerCnt(userService.followerList(userId).size());
		dto.setFollowingCnt(userService.followingList(userId).size());

		return ResponseEntity.ok(dto);
	}

	@GetMapping("/my-follow/{userId}")
	public ResponseEntity<Boolean> myFollow(@PathVariable("userId") String userId) throws Exception {
		String myId = jwtService.getUserId();
		if(userService.doIFollow(myId, userId)) return ResponseEntity.ok(true);
		return ResponseEntity.ok(false);
	}
}