package com.rest.core.controllersImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.core.controllers.UserController;
import com.rest.core.entities.User;
import com.rest.core.service.UserService;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;
	
	@Override
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

	@Override
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}

	@Override
	@RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json")
	public User addUser(User user) {
		return userService.saveUser(user);
	}

	@Override
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	@Override
	@RequestMapping(value = "/users/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateUser(User newUser) {
		return userService.updateUser(newUser);
	}

	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String up() {
		return "Up and running!";
	}

}
