package com.backend.vitalvibe.controllers;


import com.backend.vitalvibe.payload.challenge.CreateChallenge;
import com.backend.vitalvibe.services.ChallengeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    // Add an activity
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> createChallenge(@Valid @RequestBody CreateChallenge createChallenge) {
        try {
            return ResponseEntity.ok(challengeService.createChallenge(createChallenge));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public ResponseEntity<?> getAllChallenges(){
        try {
            return ResponseEntity.ok(challengeService.listAllChallenges());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getChallengeById(@PathVariable("id") String id){
        try {
            return ResponseEntity.ok(challengeService.findChallengeById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
