package com.tcs.fitnessappspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.fitnessappspringboot.entity.DietLog;

@Repository
public interface DietLogRepository extends JpaRepository<DietLog, Long> {
   
}

