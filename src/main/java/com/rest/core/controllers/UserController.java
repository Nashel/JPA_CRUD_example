package com.rest.core.controllers;

import java.util.List;
import java.util.Optional;

import com.rest.core.entities.User;

public interface UserController {
	public List<User> getUsers();

	public Optional<User> getUserById(Long id);

	public User addUser(User user);

	public String deleteUser(Long id);

	public String updateUser(User newUser);

	public String up();
}
