package com.tcs.fitnessappspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.fitnessappspringboot.entity.FollowedWorkout;

@Repository
public interface FollowedWorkoutRepository extends JpaRepository<FollowedWorkout, Long> {
    
}

