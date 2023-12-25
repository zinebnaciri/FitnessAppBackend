package com.tcs.fitnessappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.Workout;
import com.tcs.fitnessappspringboot.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Optional<Workout> getWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId);
    }

    public Workout saveWorkout(Workout workout) {
        
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

 
}
