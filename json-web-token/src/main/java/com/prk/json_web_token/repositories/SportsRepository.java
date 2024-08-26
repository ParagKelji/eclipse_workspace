package com.prk.json_web_token.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prk.json_web_token.entities.Sports;

public interface SportsRepository extends JpaRepository<Sports, Long> {
	Sports findBySportsId(Long sportsId);
}
