package com.prk.json_web_token.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.prk.json_web_token.dto.UserFavoriteSportsDto;
import com.prk.json_web_token.entities.Sports;
import com.prk.json_web_token.entities.UserFavoriteSports;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FavoriteSportsMapper {
	@Mapping(source = "sports.sportsName", target = "sportsName")
	@Mapping(source = "sports.countryOfOrigin", target = "countryOfOrigin")
	@Mapping(source = "userFavoriteSports.userId", target = "userId")
	@Mapping(source = "userFavoriteSports.sportsId", target = "sportsId")
	UserFavoriteSportsDto toFavoriteSportsDto(Sports sports, UserFavoriteSports userFavoriteSports);
}
