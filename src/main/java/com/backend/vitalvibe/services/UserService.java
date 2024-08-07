package com.backend.vitalvibe.services;

import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.BikingResults;
import com.backend.vitalvibe.models.RunningResults;
import com.backend.vitalvibe.models.User;
import com.backend.vitalvibe.models.WalkingResults;
import com.backend.vitalvibe.payload.user.UpdateBikingResults;
import com.backend.vitalvibe.payload.user.UpdateRunningResults;
import com.backend.vitalvibe.payload.user.UpdateUser;
import com.backend.vitalvibe.payload.user.UpdateWalkingResults;
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

    // Get logged in users info
    public User getLoggedInUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Can not find user"));
    }

    // update user running results
    public User updateUserRunningResults(String userId, UpdateRunningResults updateRunningResults) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Can not find user"));
        RunningResults newRunningResults;
        // Kolla om running results i usern finns och inte är null.
        if (foundUser.getRunningResults() == null) {
            newRunningResults = new RunningResults(); // Ser till att en ny lista med tomma värden skapas.
        } else {
            newRunningResults = foundUser.getRunningResults(); // Sparar userns redan befintlgia värden.
        }

        // if satsen kollar om värden från body är större än redan befintliga värden innan dem anges
        if (Optional.ofNullable(updateRunningResults.getFivekm()).isPresent() &&
                updateRunningResults.getFivekm() > newRunningResults.getFivekm()) {

            newRunningResults.setFivekm(updateRunningResults.getFivekm());
        }
        if (Optional.ofNullable(updateRunningResults.getTenkm()).isPresent() &&
                updateRunningResults.getTenkm() > newRunningResults.getTenkm()) {

            newRunningResults.setTenkm(updateRunningResults.getTenkm());
        }
        if (Optional.ofNullable(updateRunningResults.getFifteenkm()).isPresent() &&
                updateRunningResults.getFifteenkm() > newRunningResults.getFifteenkm()) {

            newRunningResults.setFifteenkm(updateRunningResults.getFifteenkm());
        }
        if (Optional.ofNullable(updateRunningResults.getHalfmarathon()).isPresent() &&
                updateRunningResults.getHalfmarathon() > newRunningResults.getHalfmarathon()) {

            newRunningResults.setHalfmarathon(updateRunningResults.getHalfmarathon());
        }
        if (Optional.ofNullable(updateRunningResults.getMarathon()).isPresent() &&
                updateRunningResults.getMarathon() > newRunningResults.getMarathon()) {

            newRunningResults.setMarathon(updateRunningResults.getMarathon());
        }

        // user uppdateras med nya värden till RunningResults och sedan sparas och returneras.
        foundUser.setRunningResults(newRunningResults);
        return userRepository.save(foundUser);
    }

    // Update users walking results
    public User updateUserWalkingResults(String userId, UpdateWalkingResults updateWalkingResults) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Can not find user"));
        WalkingResults newWalkingResults;

        // Kolla om running results i usern finns och inte är null.
        if (foundUser.getWalkingResults() == null) {
            newWalkingResults = new WalkingResults(); // Ser till att en ny lista med tomma värden skapas.
        } else {
            newWalkingResults = foundUser.getWalkingResults(); // Sparar userns redan befintlgia värden.
        }

        // if satsen kollar om värden från body är större än redan befintliga värden innan dem anges
        if (Optional.ofNullable(updateWalkingResults.getTwo_km()).isPresent() &&
                updateWalkingResults.getTwo_km() > newWalkingResults.getTwo_km()) {

            newWalkingResults.setTwo_km(updateWalkingResults.getTwo_km());
        }
        if (Optional.ofNullable(updateWalkingResults.getFive_km()).isPresent() &&
                updateWalkingResults.getFive_km() > newWalkingResults.getFive_km()) {

            newWalkingResults.setFive_km(updateWalkingResults.getFive_km());
        }
        if (Optional.ofNullable(updateWalkingResults.getSeven_km()).isPresent() &&
                updateWalkingResults.getSeven_km() > newWalkingResults.getSeven_km()) {

            newWalkingResults.setSeven_km(updateWalkingResults.getSeven_km());
        }
        if (Optional.ofNullable(updateWalkingResults.getTen_km()).isPresent() &&
                updateWalkingResults.getTen_km() > newWalkingResults.getTen_km()) {

            newWalkingResults.setTen_km(updateWalkingResults.getTen_km());
        }
        if (Optional.ofNullable(updateWalkingResults.getFifteen_km()).isPresent() &&
                updateWalkingResults.getFifteen_km() > newWalkingResults.getFifteen_km()) {

            newWalkingResults.setFifteen_km(updateWalkingResults.getFifteen_km());
        }
        if (Optional.ofNullable(updateWalkingResults.getTwenty_km()).isPresent() &&
                updateWalkingResults.getTwenty_km() > newWalkingResults.getTwenty_km()) {

            newWalkingResults.setTwenty_km(updateWalkingResults.getTwenty_km());
        }

        foundUser.setWalkingResults(newWalkingResults);
        return userRepository.save(foundUser);
    }

    // Update users biking results
    public User updateUserBikingResults(String userId, UpdateBikingResults updateBikingResults) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Can not find user"));
        BikingResults newBikingResults;

        // Kolla om running results i usern finns och inte är null.
        if (foundUser.getBikingResults() == null) {
            newBikingResults = new BikingResults(); // Ser till att en ny lista med tomma värden skapas.
        } else {
            newBikingResults = foundUser.getBikingResults(); // Sparar userns redan befintlgia värden.
        }

        if (Optional.ofNullable(updateBikingResults.getPtw_5s()).isPresent()) {
            double convertedValue = (updateBikingResults.getPtw_5s() / foundUser.getWeight());
            double roundedValue = Math.floor(convertedValue * 100) / 100;
            if (roundedValue > newBikingResults.getPtw_5s()) {
                newBikingResults.setPtw_5s(roundedValue);
            }
        }
        if (Optional.ofNullable(updateBikingResults.getPtw_60s()).isPresent()) {
            double convertedValue = (updateBikingResults.getPtw_60s() / foundUser.getWeight());
            double roundedValue = Math.floor(convertedValue * 100) / 100;
            if (roundedValue > newBikingResults.getPtw_60s()) {
                newBikingResults.setPtw_60s(roundedValue);
            }
        }
        if (Optional.ofNullable(updateBikingResults.getPtw_5min()).isPresent()) {
            double convertedValue = (updateBikingResults.getPtw_5min() / foundUser.getWeight());
            double roundedValue = Math.floor(convertedValue * 100) / 100;
            if (roundedValue > newBikingResults.getPtw_5min()) {
                newBikingResults.setPtw_5min(roundedValue);
            }
        }
        if (Optional.ofNullable(updateBikingResults.getPtw_60min()).isPresent()) {
            double convertedValue = (updateBikingResults.getPtw_60min() / foundUser.getWeight());
            double roundedValue = Math.floor(convertedValue * 100) / 100;
            if (roundedValue > newBikingResults.getPtw_60min()) {
                newBikingResults.setPtw_60min(roundedValue);
            }
        }

        foundUser.setBikingResults(newBikingResults);
        return userRepository.save(foundUser);
    }
}
