package com.rest.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.core.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Void save(Optional<User> user);
}
