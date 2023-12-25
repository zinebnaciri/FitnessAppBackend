package com.tcs.fitnessappspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.fitnessappspringboot.entity.Measurement;
import com.tcs.fitnessappspringboot.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/{measurementId}")
    public ResponseEntity<Measurement> getMeasurementById(@PathVariable Long measurementId) {
        return measurementService.getMeasurementById(measurementId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement measurement) {
        Measurement savedMeasurement = measurementService.saveMeasurement(measurement);
        return ResponseEntity.ok(savedMeasurement);
    }

    @DeleteMapping("/{measurementId}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Long measurementId) {
        measurementService.deleteMeasurement(measurementId);
        return ResponseEntity.noContent().build();
    }

    // Add other endpoints as needed
}

