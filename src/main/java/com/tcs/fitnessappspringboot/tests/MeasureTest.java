package com.tcs.fitnessappspringboot.tests;

import org.junit.jupiter.api.Test;

import com.tcs.fitnessappspringboot.entity.Measurement;
import com.tcs.fitnessappspringboot.entity.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MeasureTest {

	@Test
	public void testGettersAndSetters() {

		Long measurementId = 1L;
		User user = new User();
		LocalDate date = LocalDate.of(2023, 1, 1);
		double weight = 70.5;
		double height = 180.0;
		double bodyFatPercentage = 15.0;

		Measurement measurement = new Measurement();
		measurement.setMeasurementId(measurementId);
		measurement.setUser(user);
		measurement.setDate(date);
		measurement.setWeight(weight);
		measurement.setHeight(height);
		measurement.setBodyFatPercentage(bodyFatPercentage);

		assertEquals(measurementId, measurement.getMeasurementId());
		assertEquals(user, measurement.getUser());
		assertEquals(date, measurement.getDate());
		assertEquals(weight, measurement.getWeight());
		assertEquals(height, measurement.getHeight());
		assertEquals(bodyFatPercentage, measurement.getBodyFatPercentage());
	}

	@Test
	public void testUserAssociation() {

		Measurement measurement = new Measurement();
		User user = new User();

		measurement.setUser(user);

		assertEquals(user, measurement.getUser());
	}

	@Test
	public void testUserAssociationWithNull() {
		Measurement measurement = new Measurement();

		measurement.setUser(null);

		assertNull(measurement.getUser());
	}
}
