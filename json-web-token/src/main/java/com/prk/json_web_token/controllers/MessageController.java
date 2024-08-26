package com.prk.json_web_token.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prk.json_web_token.config.UserAuthProvider;
import com.prk.json_web_token.dto.TokenDto;
import com.prk.json_web_token.dto.UserDto;
import com.prk.json_web_token.dto.UserFavoriteSportsDto;
import com.prk.json_web_token.exception.AppException;
import com.prk.json_web_token.services.UserSportsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class MessageController {
	
	private final UserSportsService userSportsService;
	private final UserAuthProvider authProvider;
	
	@GetMapping("/messages")
	public ResponseEntity<List<String>> getAllMessages() {
		
		return ResponseEntity.ok(Arrays.asList("first", "second"));
	}
	
	@GetMapping("/favoritesports")
	public ResponseEntity<List<UserFavoriteSportsDto>> getFavoriteSports(@RequestParam(name = "token", required = false) String token) {
		System.out.println("Token value: " + token);
		UserDto dto = authProvider.getUserDtoFromDBWithJWToken(token);
		List<UserFavoriteSportsDto> sportsDtos = userSportsService.getFavoriteSports(dto.getId());
		return ResponseEntity.ok(sportsDtos);
	}
	
}
