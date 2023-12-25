package com.tcs.fitnessappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.FollowedWorkout;
import com.tcs.fitnessappspringboot.repository.FollowedWorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FollowedWorkoutService {

    @Autowired
    private FollowedWorkoutRepository followedWorkoutRepository;

    public List<FollowedWorkout> getAllFollowedWorkouts() {
        return followedWorkoutRepository.findAll();
    }

    public Optional<FollowedWorkout> getFollowedWorkoutById(Long followId) {
        return followedWorkoutRepository.findById(followId);
    }

    public FollowedWorkout saveFollowedWorkout(FollowedWorkout followedWorkout) {
        // You can add validation or business logic before saving
        return followedWorkoutRepository.save(followedWorkout);
    }

    public void deleteFollowedWorkout(Long followId) {
        followedWorkoutRepository.deleteById(followId);
    }

    // Add other methods as needed
}

