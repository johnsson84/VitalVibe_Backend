package com.backend.vitalvibe.services;

import com.backend.vitalvibe.repositories.ChallengeRepository;
import com.backend.vitalvibe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserChallengeService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ChallengeRepository challengeRepository;


    
}
