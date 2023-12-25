package com.tcs.fitnessappspringboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.fitnessappspringboot.entity.Goal;
import com.tcs.fitnessappspringboot.service.GoalService;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long goalId) {
        return goalService.getGoalById(goalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal savedGoal = goalService.saveGoal(goal);
        return ResponseEntity.ok(savedGoal);
    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long goalId) {
        goalService.deleteGoal(goalId);
        return ResponseEntity.noContent().build();
    }

    // Add other endpoints as needed
}

