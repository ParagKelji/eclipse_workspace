package com.prk.json_web_token.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.prk.json_web_token.dto.SignUpDto;
import com.prk.json_web_token.dto.UserDto;
import com.prk.json_web_token.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
	
	UserDto toUserDto(User user);
	
	@Mapping(target = "password", ignore = true)
	User signUpUser(SignUpDto signUpDto);
}
