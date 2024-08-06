package com.backend.vitalvibe.services;

import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.User;
import com.backend.vitalvibe.payload.user.UpdateUser;
import com.backend.vitalvibe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;


    // update user
    public User updateUser(String userId, UpdateUser updateUserDTO) {


        if (updateUserDTO.getPassword() != null){
            String encodedPassword = encoder.encode(updateUserDTO.getPassword());
            updateUserDTO.setPassword(encodedPassword);
        }
        return userRepository.findById(userId)
                .map(existingUser -> {
                    Optional.ofNullable(updateUserDTO.getPassword()).ifPresent(existingUser::setPassword);
                    Optional.ofNullable(updateUserDTO.getEmail()).ifPresent(existingUser::setEmail);
                    Optional.ofNullable(updateUserDTO.getFirstName()).ifPresent(existingUser::setFirstName);
                    Optional.ofNullable(updateUserDTO.getLastName()).ifPresent(existingUser::setLastName);
                    Optional.ofNullable(updateUserDTO.getWeight()).ifPresent(existingUser::setWeight);
                    Optional.ofNullable(updateUserDTO.getVo2max()).ifPresent(existingUser::setVo2max);
                    Optional.ofNullable(updateUserDTO.getFivekm()).ifPresent(existingUser::setFivekm);
                    Optional.ofNullable(updateUserDTO.getTenkm()).ifPresent(existingUser::setTenkm);
                    Optional.ofNullable(updateUserDTO.getFifteenkm()).ifPresent(existingUser::setFifteenkm);
                    Optional.ofNullable(updateUserDTO.getHalfmarathon()).ifPresent(existingUser::setHalfmarathon);
                    Optional.ofNullable(updateUserDTO.getMarathon()).ifPresent(existingUser::setMarathon);
                    Optional.ofNullable(updateUserDTO.getThemeColor()).ifPresent(existingUser::setThemeColor);

                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new EntityNotFoundException("User with id:" + userId + " was not found!"));
    }

    // delete user
    public ResponseEntity<String> deleteUser(String userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Can not find user"));

            userRepository.deleteById(userId);

        return ResponseEntity.ok("User deleted");
    }
}
