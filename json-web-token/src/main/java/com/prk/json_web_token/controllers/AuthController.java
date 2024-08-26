package com.prk.json_web_token.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prk.json_web_token.config.UserAuthProvider;
import com.prk.json_web_token.dto.CredentialsDto;
import com.prk.json_web_token.dto.SignUpDto;
import com.prk.json_web_token.dto.UserDto;
import com.prk.json_web_token.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	private final UserAuthProvider authProvider;
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
		UserDto user = userService.login(credentialsDto);
		user.setToken(authProvider.createToken(user));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
		UserDto user = userService.register(signUpDto);
		user.setToken(authProvider.createToken(user));
		return ResponseEntity.created(URI.create("/users" + user.getId())).body(user);
	}
	
}
