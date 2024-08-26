package com.prk.json_web_token.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prk.json_web_token.dto.UserFavoriteSportsDto;
import com.prk.json_web_token.entities.Sports;
import com.prk.json_web_token.entities.UserFavoriteSports;
import com.prk.json_web_token.mappers.FavoriteSportsMapper;
import com.prk.json_web_token.repositories.SportsRepository;
import com.prk.json_web_token.repositories.UserFavoriteSportsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSportsService {
	private final SportsRepository sportsRepository;
	private final UserFavoriteSportsRepository favoriteSportsRepository ;
	@Autowired
	FavoriteSportsMapper favoriteSportsMapper;
	
	public List<UserFavoriteSportsDto> getFavoriteSports(Long userId) {
		List<UserFavoriteSportsDto> dtos = new ArrayList<>();
		Optional<List<UserFavoriteSports>> oUserFavSports = favoriteSportsRepository.findByUserId(userId);
		if ( oUserFavSports.isPresent() ) {
			List<UserFavoriteSports> userFavoriteSports = 
					Optional.ofNullable(oUserFavSports)
					.orElse(Optional.empty())
					.stream()
					.toList()
					.get(0)
	        ;
			userFavoriteSports.stream()
	        .forEach((item) -> {
	        	Sports sports = sportsRepository.findBySportsId(item.getSportsId());
	        	UserFavoriteSportsDto dto =  favoriteSportsMapper.toFavoriteSportsDto(sports, item);
	        	dtos.add(dto);
	        })
	        ;
			
		}
		return dtos;
	}
}
