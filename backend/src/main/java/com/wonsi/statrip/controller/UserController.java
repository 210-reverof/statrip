package com.wonsi.statrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<UserDto> test(@RequestHeader("token") String refreshtoken) throws Exception {
		String userId = userService.findUserByRefreshToken(refreshtoken);
		return ResponseEntity.ok(userService.findUserByUserId(userId));
	}
}
