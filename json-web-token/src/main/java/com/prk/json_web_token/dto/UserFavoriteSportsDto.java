package com.prk.json_web_token.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFavoriteSportsDto {
	private Long userId;
	private Long sportsId;
	private String sportsName;
	private String countryOfOrigin;
}
