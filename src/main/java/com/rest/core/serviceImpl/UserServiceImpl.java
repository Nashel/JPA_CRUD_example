package com.rest.core.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.core.entities.User;
import com.rest.core.repositories.UserRepository;
import com.rest.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	@Override
	public User saveUser(User newUser) {
		if (newUser != null) {
			return userRepository.save(newUser);
		}
		return new User();
	}

	@Override
	public String deleteUser(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "User " + id + " correctly deleted";
		}
		return "Error! User not found in the database";
	}

	@Override
	public String updateUser(User modifiedUser) {
		Long num = modifiedUser.getId();
		if (userRepository.findById(num).isPresent()) {
			User user2modify = new User();
			user2modify.setId(modifiedUser.getId());
			user2modify.setName(modifiedUser.getName());
			user2modify.setSurname(modifiedUser.getSurname());
			user2modify.setDni(modifiedUser.getDni());
			userRepository.save(modifiedUser);
			return "User correctly modified";
		}
		return "Error! The User couldn't be modified";
	}
}
