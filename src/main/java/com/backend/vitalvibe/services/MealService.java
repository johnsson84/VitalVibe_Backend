package com.backend.vitalvibe.services;


import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.Meal;
import com.backend.vitalvibe.payload.meal.CreateMeal;
import com.backend.vitalvibe.payload.meal.UpdateMeal;
import com.backend.vitalvibe.repositories.MealRepository;
import com.backend.vitalvibe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    UserRepository userRepository;


    // Add a meal
    public ResponseEntity<?> addMeal(CreateMeal meal) {
        Meal newMeal = new Meal();
        newMeal.setUserId(meal.getUserId());
        newMeal.setMealType(meal.getMealType());
        newMeal.setContent(meal.getContent());
        newMeal.setCalories(meal.getCalories());

        mealRepository.save(newMeal);
        return ResponseEntity.ok("Meal added successfully");
    }

    // List all meals logged by a user
    public List<Meal> getAllMeals(String userId) {
        return mealRepository.findByUserId(userId);
    }

    // Update a logged meal
    public Meal updateMeal( String mealId, UpdateMeal updateMeal) {

        return mealRepository.findById(mealId).map(existingMeal -> {
            Optional.ofNullable(updateMeal.getMealType()).ifPresent(existingMeal::setMealType);
            Optional.ofNullable(updateMeal.getContent()).ifPresent(existingMeal::setContent);
            Optional.ofNullable(updateMeal.getCalories()).ifPresent(existingMeal::setCalories);

            return mealRepository.save(existingMeal);

        }).orElseThrow(() -> new EntityNotFoundException("Meal with id " + mealId + " not found"));
    }


    // Delete a meal with mealId
    public ResponseEntity<?> deleteMeal(String mealId) {
        if (mealRepository.existsById(mealId)) {
            mealRepository.deleteById(mealId);
            return ResponseEntity.ok("Meal deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meal with id " + mealId + " not found");
        }
    }
}
