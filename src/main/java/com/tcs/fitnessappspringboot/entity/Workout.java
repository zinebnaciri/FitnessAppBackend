package com.tcs.fitnessappspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutId;

    private String name;
    private String description;
    private int duration;
    private String difficulty;
    
    
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public Long getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
   
}
