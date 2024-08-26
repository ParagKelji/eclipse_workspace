package com.prk.json_web_token.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user_favorite_sports")
public class UserFavoriteSports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ufs_id;
	@Column(name = "user_id", nullable = false)
	private Long userId;
	@Column(name = "sports_id", nullable = false)
	private Long sportsId;
	
}
