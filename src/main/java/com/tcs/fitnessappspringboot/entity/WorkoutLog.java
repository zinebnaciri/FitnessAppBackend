package com.tcs.fitnessappspringboot.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "workout_logs")
public class WorkoutLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "workout_id")
	private Workout workout;

	private LocalDate logDate;
	private int duration;
	private int caloriesBurned;

}
