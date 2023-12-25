package com.tcs.fitnessappspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.entity.DietLog;
import com.tcs.fitnessappspringboot.repository.DietLogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DietLogService {

    @Autowired
    private DietLogRepository dietLogRepository;

    public List<DietLog> getAllDietLogs() {
        return dietLogRepository.findAll();
    }

    public Optional<DietLog> getDietLogById(Long logId) {
        return dietLogRepository.findById(logId);
    }

    public DietLog saveDietLog(DietLog dietLog) {
        // You can add validation or business logic before saving
        return dietLogRepository.save(dietLog);
    }

    public void deleteDietLog(Long logId) {
        dietLogRepository.deleteById(logId);
    }

    // Add other methods as needed
}

