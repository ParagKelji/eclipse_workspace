package com.prk.json_web_token.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prk.json_web_token.entities.UserFavoriteSports;

public interface UserFavoriteSportsRepository extends JpaRepository<UserFavoriteSports, Long> {
	Optional<List<UserFavoriteSports>> findByUserId(Long userId);
}
