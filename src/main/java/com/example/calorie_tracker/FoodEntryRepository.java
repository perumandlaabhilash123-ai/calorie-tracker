package com.example.calorie_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodEntryRepository
        extends JpaRepository<FoodEntry, Long> {
}