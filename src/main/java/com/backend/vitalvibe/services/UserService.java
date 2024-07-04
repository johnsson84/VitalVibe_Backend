package com.backend.vitalvibe.services;

import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.backend.vitalvibe.payload.user.UpdateUser;
import com.backend.vitalvibe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

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
                    //Optional.ofNullable(updateUserDTO.getVo2max()).ifPresent(existingUser::setVo2max);
                    Optional.ofNullable(updateUserDTO.getVo2max())
                            .filter(newVo2max -> !newVo2max.equals(existingUser.getVo2max()))
                            .ifPresent(existingUser::setVo2max);
                    Optional.ofNullable(updateUserDTO.getFivekm()).ifPresent(existingUser::setFivekm);
                    Optional.ofNullable(updateUserDTO.getTenkm()).ifPresent(existingUser::setTenkm);
                    Optional.ofNullable(updateUserDTO.getFifteenkm()).ifPresent(existingUser::setFifteenkm);
                    Optional.ofNullable(updateUserDTO.getHalfmarathon()).ifPresent(existingUser::setHalfmarathon);
                    Optional.ofNullable(updateUserDTO.getMarathon()).ifPresent(existingUser::setMarathon);


                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new EntityNotFoundException("User with id:" + userId + " was not found!"));
    }
}
