package com.backend.vitalvibe.repositories;

import com.backend.vitalvibe.models.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MealRepository extends MongoRepository<Meal, String> {

    List<Meal> findByUserId(String userId);
}
