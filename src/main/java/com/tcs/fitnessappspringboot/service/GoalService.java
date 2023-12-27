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

	public Optional<Goal> getGoalById(Long goalId, Long userId) {
        // You might want to add logic here to ensure the goal belongs to the specified user
        // For example, you could check if the goal has the correct user ID
        return goalRepository.findById(goalId)
                .filter(goal -> goal.getUser().getUserId().equals(userId));
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
