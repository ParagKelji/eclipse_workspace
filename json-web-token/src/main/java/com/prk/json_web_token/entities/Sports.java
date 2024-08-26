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
@Table(name = "sports")
public class Sports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sports_id", nullable = false)
	private Long sportsId;
	@Column(name = "sports_name", nullable = false)
	private String sportsName;
	@Column(name = "country_of_origin", nullable = false)
	private String countryOfOrigin;
}
