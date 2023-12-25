package com.tcs.fitnessappspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.fitnessappspringboot.entity.WorkoutLog;
import com.tcs.fitnessappspringboot.service.WorkoutLogService;

import java.util.List;

@RestController
@RequestMapping("/api/workout-logs")
public class WorkoutLogController {

    @Autowired
    private WorkoutLogService workoutLogService;

    @GetMapping
    public List<WorkoutLog> getAllWorkoutLogs() {
        return workoutLogService.getAllWorkoutLogs();
    }

    @GetMapping("/{logId}")
    public ResponseEntity<WorkoutLog> getWorkoutLogById(@PathVariable Long logId) {
        return workoutLogService.getWorkoutLogById(logId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WorkoutLog> createWorkoutLog(@RequestBody WorkoutLog workoutLog) {
        WorkoutLog savedWorkoutLog = workoutLogService.saveWorkoutLog(workoutLog);
        return ResponseEntity.ok(savedWorkoutLog);
    }

    @DeleteMapping("/{logId}")
    public ResponseEntity<Void> deleteWorkoutLog(@PathVariable Long logId) {
        workoutLogService.deleteWorkoutLog(logId);
        return ResponseEntity.noContent().build();
    }

    // Add other endpoints as needed
}

