package com.backend.vitalvibe.controllers;


import com.backend.vitalvibe.models.Meal;
import com.backend.vitalvibe.payload.meal.CreateMeal;
import com.backend.vitalvibe.payload.meal.UpdateMeal;
import com.backend.vitalvibe.services.MealService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {

    @Autowired
    MealService mealService;

    // Add a meal
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> createMeal(@Valid @RequestBody CreateMeal meal) {
        try {
            return ResponseEntity.ok(mealService.addMeal(meal));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // List all meals logged
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/list-all/{userId}")
    public ResponseEntity<?> getAllMeals(@PathVariable("userId") String userId) {
        List<Meal> foundMeals = mealService.getAllMeals(userId);
        if (foundMeals.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No meals found");
        } else {
            return ResponseEntity.ok(foundMeals);
        }
    }

    // Update a meal
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{mealId}")
    public ResponseEntity<?> updateMeal(@PathVariable("mealId") String mealId, @Valid @RequestBody UpdateMeal meal) {
        Meal updatedMeal = mealService.updateMeal(mealId, meal);
        return ResponseEntity.ok(updatedMeal);
    }

    // Delete an activity
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{mealId}")
    public ResponseEntity<?> deleteMeal(@PathVariable("mealId") String mealId) {
        return mealService.deleteMeal(mealId);
    }
}
