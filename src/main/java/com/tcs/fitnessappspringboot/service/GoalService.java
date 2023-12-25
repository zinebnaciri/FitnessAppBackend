package com.tcs.fitnessappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.Goal;
import com.tcs.fitnessappspringboot.repository.GoalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

	@Autowired
	private GoalRepository goalRepository;

	public List<Goal> getAllGoals() {
		return goalRepository.findAll();
	}

	public Optional<Goal> getGoalById(Long goalId) {
		return goalRepository.findById(goalId);
	}

	public Goal saveGoal(Goal goal) {
		// You can add validation or business logic before saving
		return goalRepository.save(goal);
	}

	public void deleteGoal(Long goalId) {
		goalRepository.deleteById(goalId);
	}

	// Add other methods as needed
}
