package com.tcs.fitnessappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.Measurement;
import com.tcs.fitnessappspringboot.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Optional<Measurement> getMeasurementById(Long measurementId) {
        return measurementRepository.findById(measurementId);
    }

    public Measurement saveMeasurement(Measurement measurement) {
        // You can add validation or business logic before saving
        return measurementRepository.save(measurement);
    }

    public void deleteMeasurement(Long measurementId) {
        measurementRepository.deleteById(measurementId);
    }

    // Add other methods as needed
}
