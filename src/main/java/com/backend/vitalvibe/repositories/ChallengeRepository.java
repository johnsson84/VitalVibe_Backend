package com.backend.vitalvibe.repositories;

import com.backend.vitalvibe.models.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChallengeRepository  extends MongoRepository<Challenge, String> {


}
