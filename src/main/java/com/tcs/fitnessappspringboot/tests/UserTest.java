package com.tcs.fitnessappspringboot.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.tcs.fitnessappspringboot.entity.Goal;
import com.tcs.fitnessappspringboot.entity.User;

public class UserTest {

	@Test
	public void testGettersAndSetters() {
		// Arrange
		Long userId = 1L;
		String firstName = "John";
		String lastName = "Doe";
		String username = "john.doe";
		String password = "password";
		String email = "john.doe@gmail.com";
		LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
		String gender = "Male";
		double height = 180.0;
		double weight = 75.0;

		User user = new User();
		user.setUserId(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setDateOfBirth(dateOfBirth);
		user.setGender(gender);
		user.setHeight(height);
		user.setWeight(weight);

		// Act & Assert
		assertEquals(userId, user.getUserId());
		assertEquals(firstName, user.getFirstName());
		assertEquals(lastName, user.getLastName());
		assertEquals(username, user.getUsername());
		assertEquals(password, user.getPassword());
		assertEquals(email, user.getEmail());
		assertEquals(dateOfBirth, user.getDateOfBirth());
		assertEquals(gender, user.getGender());
		assertEquals(height, user.getHeight());
		assertEquals(weight, user.getWeight());
	}

	@Test
	public void testAuthorities() {

		User user = new User();

		assertNull(user.getAuthorities());
	}

	@Test
	public void testUserDetailsMethods() {

		User user = new User();

		assertTrue(user.isAccountNonExpired());
		assertTrue(user.isAccountNonLocked());
		assertTrue(user.isCredentialsNonExpired());
		assertTrue(user.isEnabled());
	}

	@Test
	public void testGoalsProperty() {

		User user = new User();
		Goal goal = new Goal();

		user.setGoals(Collections.singletonList(goal));

		assertEquals(Collections.singletonList(goal), user.getGoals());
	}
}
