package com.wonsi.statrip.controller;

import com.wonsi.statrip.model.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wonsi.statrip.model.dto.UserDto;
import com.wonsi.statrip.model.dto.response.LoginResDto;
import com.wonsi.statrip.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/join")
	public ResponseEntity<Void> join(@RequestBody UserDto userDto) throws Exception {
		userService.join(userDto);
		return ResponseEntity.ok(null);	
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResDto> login(@RequestBody UserDto userDto) throws Exception {
		return ResponseEntity.ok(userService.login(userDto));	
	}
	
	@GetMapping("/info")
<<<<<<< HEAD
	public ResponseEntity<UserDto> info(@RequestAttribute("userId") String userId) throws Exception {
		System.out.println(userId + "======" + userService.findUserByUserId(userId));
		return ResponseEntity.ok(userService.findUserByUserId(userId));	
=======
	public ResponseEntity<UserDto> info(HttpServletRequest request) throws Exception {
		String userId = jwtService.getUserId();
		return ResponseEntity.ok(userService.findUserByUserId(userId));
	}

	@GetMapping("/logout/{userId}")
	public ResponseEntity<Void> logout(@PathVariable("userId") String userId) {
		userService.logout(userId);
		return ResponseEntity.ok(null);
>>>>>>> feature13-authfront
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<Void> refresh(@RequestBody UserDto userDto) throws Exception {		
		return ResponseEntity.ok(null);	
	}
}
