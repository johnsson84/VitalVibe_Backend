package com.backend.vitalvibe.repositories;

import com.backend.vitalvibe.models.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity, String> {

}
