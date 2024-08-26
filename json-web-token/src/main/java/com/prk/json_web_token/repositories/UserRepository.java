package com.prk.json_web_token.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prk.json_web_token.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByLogin(String login);
	
}
