package com.tcs.fitnessappspringboot.tests;

import org.junit.jupiter.api.Test;

import com.tcs.fitnessappspringboot.entity.Workout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutTest {

	@Test
	public void testGettersAndSetters() {

		Long workoutId = 1L;
		String name = "Cardio";
		String description = "Aerobic exercise";
		int duration = 30;
		String difficulty = "Intermediate";

		Workout workout = new Workout();
		workout.setWorkoutId(workoutId);
		workout.setName(name);
		workout.setDescription(description);
		workout.setDuration(duration);
		workout.setDifficulty(difficulty);

		assertEquals(workoutId, workout.getWorkoutId());
		assertEquals(name, workout.getName());
		assertEquals(description, workout.getDescription());
		assertEquals(duration, workout.getDuration());
		assertEquals(difficulty, workout.getDifficulty());
	}
}
