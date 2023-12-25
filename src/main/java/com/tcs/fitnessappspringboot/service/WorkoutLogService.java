package com.tcs.fitnessappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.WorkoutLog;
import com.tcs.fitnessappspringboot.repository.WorkoutLogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutLogService {

    @Autowired
    private WorkoutLogRepository workoutLogRepository;

    public List<WorkoutLog> getAllWorkoutLogs() {
        return workoutLogRepository.findAll();
    }

    public Optional<WorkoutLog> getWorkoutLogById(Long logId) {
        return workoutLogRepository.findById(logId);
    }

    public WorkoutLog saveWorkoutLog(WorkoutLog workoutLog) {
       
        return workoutLogRepository.save(workoutLog);
    }

    public void deleteWorkoutLog(Long logId) {
        workoutLogRepository.deleteById(logId);
    }

}

