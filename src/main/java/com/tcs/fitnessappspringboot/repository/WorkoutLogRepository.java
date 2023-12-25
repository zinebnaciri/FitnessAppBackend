package com.tcs.fitnessappspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.fitnessappspringboot.entity.WorkoutLog;

@Repository
public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {
    
}

