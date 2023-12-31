package com.tcs.fitnessappspringboot.tests;

import org.junit.jupiter.api.Test;

import com.tcs.fitnessappspringboot.entity.Goal;
import com.tcs.fitnessappspringboot.entity.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GoalTest {

	@Test
	public void testGettersAndSetters() {

		Long goalId = 1L;
		User user = new User();
		String goalType = "Weight Loss";
		double target = 10.0;
		LocalDate startDate = LocalDate.of(2023, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 12, 31);
		double progress = 5.0;
		String status = "In Progress";

		Goal goal = new Goal();
		goal.setGoalId(goalId);
		goal.setUser(user);
		goal.setGoalType(goalType);
		goal.setTarget(target);
		goal.setStartDate(startDate);
		goal.setEndDate(endDate);
		goal.setProgress(progress);
		goal.setStatus(status);

		assertEquals(goalId, goal.getGoalId());
		assertEquals(user, goal.getUser());
		assertEquals(goalType, goal.getGoalType());
		assertEquals(target, goal.getTarget());
		assertEquals(startDate, goal.getStartDate());
		assertEquals(endDate, goal.getEndDate());
		assertEquals(progress, goal.getProgress());
		assertEquals(status, goal.getStatus());
	}

	@Test
	public void testUserAssociation() {

		Goal goal = new Goal();
		User user = new User();

		goal.setUser(user);

		assertEquals(user, goal.getUser());
	}

	@Test
	public void testUserAssociationWithNull() {

		Goal goal = new Goal();

		goal.setUser(null);

		assertNull(goal.getUser());
	}
}
