package com.example.calorie_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class FoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;
    private String quantity;
    private String mealType;
    private double calories;
    private double protein;
    private Double carbs;
    private Double fiber;
    private Double fat;
    private LocalDate entryDate;

    public FoodEntry() {
    }

    public Long getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
    
    public Double getCarbs() {
    return carbs;
}

public void setCarbs(Double carbs) {
    this.carbs = carbs;
}

public Double getFiber() {
    return fiber;
}

public void setFiber(Double fiber) {
    this.fiber = fiber;
}

public Double getFat() {
    return fat;
}

public void setFat(Double fat) {
    this.fat = fat;
}
}