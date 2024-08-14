package com.backend.vitalvibe.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "userchallenges")
public class UserChallenge {

    // VARIABLES
    private boolean completed;
    private LocalDateTime activatedAt;
    private LocalDateTime completedAt;
    private Challenge challenge;


    public UserChallenge(Challenge challenge) {
        this.challenge = challenge;
        this.completed = false;
        this.activatedAt = LocalDateTime.now();
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(LocalDateTime activatedAt) {
        this.activatedAt = activatedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }


    //GETTERS & SETTERS





}
