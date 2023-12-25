package com.tcs.fitnessappspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.Diet;

import com.tcs.fitnessappspringboot.repository.DietRepository;

@Service
public class DietService {
	
	@Autowired
	private DietRepository dietRepository;
	
	public List<Diet> getAllDiets() {
		return dietRepository.findAll();
	}

	public Optional<Diet> getDietById(Long dietId) {
		return dietRepository.findById(dietId);
	}

	public Diet saveDiet(Diet diet) {
		// You can add validation or business logic before saving
		return dietRepository.save(diet);
	}

	public void deleteDiet (Long dietId) {
		dietRepository.deleteById(dietId);
	}
	

}
