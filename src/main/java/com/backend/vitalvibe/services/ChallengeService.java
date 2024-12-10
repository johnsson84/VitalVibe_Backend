package com.backend.vitalvibe.services;

import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.Challenge;
import com.backend.vitalvibe.payload.challenge.CreateChallenge;
import com.backend.vitalvibe.repositories.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChallengeService {
    @Autowired
    ChallengeRepository challengeRepository;

    // Add a new challenge
    public ResponseEntity<?> createChallenge(CreateChallenge createChallenge) {

        Challenge newChallenge = new Challenge();
        newChallenge.setDistance(createChallenge.getDistance());
        //eventuellt modifierbar
        LocalDateTime countDown = LocalDateTime.now().plusDays(createChallenge.getEndDate());
        newChallenge.setEndDate(countDown);


        challengeRepository.save(newChallenge);

        return ResponseEntity.ok("Challenge was created!");
    }

    // List all challenges
    public List<Challenge> listAllChallenges() {
        return challengeRepository.findAll();
    }

    // find a challenge
    public Challenge findChallengeById(String id) {
     return   challengeRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Challenge not found"));
    }
}
