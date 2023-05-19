package com.wonsi.statrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.dto.response.LoginResDto;
import com.wonsi.statrip.model.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResDto> login(@RequestBody UserDto userDto) throws Exception {		
		return ResponseEntity.ok(userService.login(userDto));	
	}
	
	@GetMapping("/info")
	public ResponseEntity<UserDto> info(@RequestAttribute("userId") String userId) throws Exception {		
		return ResponseEntity.ok(userService.findUserByUserId(userId));	
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<Void> refresh(@RequestBody UserDto userDto) throws Exception {		
		return ResponseEntity.ok(null);	
	}
}
