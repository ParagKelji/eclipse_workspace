package com.prk.json_web_token.config;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.prk.json_web_token.dto.UserDto;
import com.prk.json_web_token.entities.User;
import com.prk.json_web_token.exception.AppException;
import com.prk.json_web_token.mappers.UserMapper;
import com.prk.json_web_token.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {
	
	private final UserRepository userRepository;
	
	private final UserMapper userMapper;
	
	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKey;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String createToken(UserDto userDto) {
		Date now = new Date();
		Date validUntil = new Date(now.getTime() + 3_600_000);
		return JWT.create()
				.withIssuer(userDto.getLogin())
				.withIssuedAt(now)
				.withExpiresAt(validUntil)
				.withClaim("firstName", userDto.getFirstName())
				.withClaim("lastName", userDto.getLastName())
				.sign(Algorithm.HMAC256(secretKey));
	}
	
	public Authentication validateToken(String token) {
		UserDto userDto = getUserDtoWithJWToken(token);
		return new UsernamePasswordAuthenticationToken(userDto, null, Collections.emptyList());
	}
	
	public Authentication validateTokenWithDBCheck(String token) {
		UserDto userDto = getUserDtoFromDBWithJWToken(token);
		return new UsernamePasswordAuthenticationToken(userDto, null, Collections.emptyList());
	}
	
	public UserDto getUserDtoWithJWToken(String token) {
		DecodedJWT decodedJWT = decodeJWT(token);
		
		UserDto userDto = UserDto.builder()
							.login(decodedJWT.getIssuer())
							.firstName(decodedJWT.getClaim("firstName").asString())
							.lastName(decodedJWT.getClaim("lastName").asString())
							.build();
		return userDto;
	}
	
	public UserDto getUserDtoFromDBWithJWToken(String token) {
		DecodedJWT decodedJWT = decodeJWT(token);
		
		User user = userRepository.findByLogin(decodedJWT.getIssuer())
				.orElseThrow(() -> new AppException("Unknow User", HttpStatus.NOT_FOUND));
		UserDto userDto = userMapper.toUserDto(user);
		return userDto;
	}
	
	public DecodedJWT decodeJWT(String token) {
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		Verification verification = JWT.require(algorithm);
		DecodedJWT decodedJWT = verification.build().verify(token);
		return decodedJWT;
	}
	
}
