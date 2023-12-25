package com.tcs.fitnessappspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.fitnessappspringboot.entity.FollowedWorkout;
import com.tcs.fitnessappspringboot.service.FollowedWorkoutService;

import java.util.List;

@RestController
@RequestMapping("/api/followed-workouts")
public class FollowedWorkoutController {

    @Autowired
    private FollowedWorkoutService followedWorkoutService;

    @GetMapping
    public List<FollowedWorkout> getAllFollowedWorkouts() {
        return followedWorkoutService.getAllFollowedWorkouts();
    }

    @GetMapping("/{followId}")
    public ResponseEntity<FollowedWorkout> getFollowedWorkoutById(@PathVariable Long followId) {
        return followedWorkoutService.getFollowedWorkoutById(followId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FollowedWorkout> createFollowedWorkout(@RequestBody FollowedWorkout followedWorkout) {
        FollowedWorkout savedFollowedWorkout = followedWorkoutService.saveFollowedWorkout(followedWorkout);
        return ResponseEntity.ok(savedFollowedWorkout);
    }

    @DeleteMapping("/{followId}")
    public ResponseEntity<Void> deleteFollowedWorkout(@PathVariable Long followId) {
        followedWorkoutService.deleteFollowedWorkout(followId);
        return ResponseEntity.noContent().build();
    }

    // Add other endpoints as needed
}

