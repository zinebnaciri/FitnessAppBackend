package com.tcs.fitnessappspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.fitnessappspringboot.entity.Goal;
import com.tcs.fitnessappspringboot.entity.User;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

	  List<Goal> findByUser(User user);
}

