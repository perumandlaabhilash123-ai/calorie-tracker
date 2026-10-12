package com.example.calorie_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightEntryRepository
        extends JpaRepository<WeightEntry, Long> {
}