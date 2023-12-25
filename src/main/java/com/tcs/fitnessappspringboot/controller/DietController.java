package com.tcs.fitnessappspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.fitnessappspringboot.entity.Diet;
import com.tcs.fitnessappspringboot.service.DietService;

import java.util.List;

@RestController
@RequestMapping("/api/diets")
public class DietController {

    @Autowired
    private DietService dietService;

    @GetMapping
    public List<Diet> getAllDiets() {
        return dietService.getAllDiets();
    }

    @GetMapping("/{dietId}")
    public ResponseEntity<Diet> getDietById(@PathVariable Long dietId) {
        return dietService.getDietById(dietId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Diet> createDiet(@RequestBody Diet diet) {
        Diet savedDiet = dietService.saveDiet(diet);
        return ResponseEntity.ok(savedDiet);
    }

    @DeleteMapping("/{dietId}")
    public ResponseEntity<Void> deleteDiet(@PathVariable Long dietId) {
        dietService.deleteDiet(dietId);
        return ResponseEntity.noContent().build();
    }

    // Add other endpoints as needed
}

