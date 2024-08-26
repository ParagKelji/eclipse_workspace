package com.prk.json_web_token.services;

import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prk.json_web_token.dto.CredentialsDto;
import com.prk.json_web_token.dto.SignUpDto;
import com.prk.json_web_token.dto.UserDto;
import com.prk.json_web_token.entities.User;
import com.prk.json_web_token.exception.AppException;
import com.prk.json_web_token.mappers.UserMapper;
import com.prk.json_web_token.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private final UserMapper userMapper;
	
	public UserDto login(CredentialsDto credentialsDto) {
		User user = userRepository.findByLogin(credentialsDto.login())
			.orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));
		
		if ( passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword()) ) {
			return userMapper.toUserDto(user);
		}
		throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
	}
	
	public UserDto register(SignUpDto signUpDto) {
		Optional<User> oUser = userRepository.findByLogin(signUpDto.login());
		
		if ( oUser.isPresent() ) {
			throw new AppException("User already exists", HttpStatus.BAD_REQUEST);
		}
		User user = userMapper.signUpUser(signUpDto);
		user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));
		User savedUser = userRepository.save(user);
		
		return userMapper.toUserDto(savedUser);
	}
}
