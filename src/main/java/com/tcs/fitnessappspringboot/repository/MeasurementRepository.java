package com.tcs.fitnessappspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.fitnessappspringboot.entity.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
  
}

