package com.backend.vitalvibe.repositories;

import com.backend.vitalvibe.models.UserChallenge;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserChallengeRepository extends MongoRepository<UserChallenge, String> {
    List<UserChallenge> findByUserId(String userId);
}
