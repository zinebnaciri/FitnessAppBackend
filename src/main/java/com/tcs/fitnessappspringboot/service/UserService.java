package com.tcs.fitnessappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.User;
import com.tcs.fitnessappspringboot.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
