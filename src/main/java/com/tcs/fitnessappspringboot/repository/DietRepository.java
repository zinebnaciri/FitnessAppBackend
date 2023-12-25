package com.tcs.fitnessappspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.fitnessappspringboot.entity.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
 
}

