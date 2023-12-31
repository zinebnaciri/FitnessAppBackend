package com.tcs.fitnessappspringboot.tests;

import org.junit.jupiter.api.Test;

import com.tcs.fitnessappspringboot.entity.Diet;
import com.tcs.fitnessappspringboot.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DietTest {

	@Test
	public void testGettersAndSetters() {

		Long dietId = 1L;
		User user = new User();
		String name = "Low Carb";
		String description = "A diet low in carbohydrates";
		int calories = 1500;

		Diet diet = new Diet();
		diet.setDietId(dietId);
		diet.setUser(user);
		diet.setName(name);
		diet.setDescription(description);
		diet.setCalories(calories);

		assertEquals(dietId, diet.getDietId());
		assertEquals(user, diet.getUser());
		assertEquals(name, diet.getName());
		assertEquals(description, diet.getDescription());
		assertEquals(calories, diet.getCalories());
	}

	@Test
	public void testUserAssociation() {

		Diet diet = new Diet();
		User user = new User();

		diet.setUser(user);

		assertEquals(user, diet.getUser());
	}

	@Test
	public void testUserAssociationWithNull() {
		Diet diet = new Diet();

		diet.setUser(null);

		assertNull(diet.getUser());
	}
}
