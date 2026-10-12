package com.example.calorie_tracker;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/foods")
public class FoodEntryController {

    private final FoodEntryRepository repository;

    public FoodEntryController(FoodEntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FoodEntry> getAllFoods() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodEntry addFood(@RequestBody FoodEntry food) {

        if (food.getFoodName() == null
                || food.getFoodName().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Food name is required");
        }

        if (food.getEntryDate() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Date is required");
        }

        if (!Double.isFinite(food.getCalories())
                || !Double.isFinite(food.getProtein())
                || food.getCalories() < 0
                || food.getProtein() < 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Calories and protein must be valid, non-negative numbers");
        }

        return repository.save(food);
    }
    @PutMapping("/{id}")
public FoodEntry updateFood(
        @PathVariable Long id,
        @RequestBody FoodEntry updatedFood) {

    FoodEntry existingFood = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Food entry not found"
            ));

    if (updatedFood.getFoodName() == null
            || updatedFood.getFoodName().isBlank()) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Food name is required"
        );
    }

    if (updatedFood.getEntryDate() == null) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Date is required"
        );
    }

    existingFood.setFoodName(updatedFood.getFoodName());
    existingFood.setMealType(updatedFood.getMealType());
    existingFood.setQuantity(updatedFood.getQuantity());
    existingFood.setCalories(updatedFood.getCalories());
    existingFood.setProtein(updatedFood.getProtein());
    existingFood.setCarbs(updatedFood.getCarbs());
    existingFood.setFiber(updatedFood.getFiber());
    existingFood.setFat(updatedFood.getFat());
    existingFood.setEntryDate(updatedFood.getEntryDate());

    return repository.save(existingFood);
}
        @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Food entry not found");
        }

        repository.deleteById(id);
    }
}
