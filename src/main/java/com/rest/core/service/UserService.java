package com.rest.core.service;

import java.util.List;
import java.util.Optional;

import com.rest.core.entities.User;

public interface UserService {
	public List<User> findAllUsers();

	public Optional<User> findUserById(Long id);

	public User saveUser(User newUser);

	public String deleteUser(Long id);

	public String updateUser(User modifiedUser);
}
