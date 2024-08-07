package com.backend.vitalvibe.controllers;

import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.User;
import com.backend.vitalvibe.payload.user.UpdateBikingResults;
import com.backend.vitalvibe.payload.user.UpdateRunningResults;
import com.backend.vitalvibe.payload.user.UpdateUser;
import com.backend.vitalvibe.payload.user.UpdateWalkingResults;
import com.backend.vitalvibe.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //update user
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUser updateUser, @PathVariable("userId") String userId){
        try{
            User updatedUser = userService.updateUser(userId, updateUser);
            return ResponseEntity.ok(updatedUser);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //delete user
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@Valid @PathVariable("userId") String userId){
        try{
            return userService.deleteUser(userId);

        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    // Get logged in user
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/findUser/{userId}")
    public ResponseEntity<?> getLoggedInUser(@PathVariable("userId") String userId) {
        try {
            User loggedInUser = userService.getLoggedInUser(userId);
            return ResponseEntity.ok(loggedInUser);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // Add running result
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/updateRunningResults/{userId}")
    public ResponseEntity<?> updateRunning(@PathVariable("userId") String userId, @RequestBody UpdateRunningResults updateRunningResults) {
        try {
            User updatedUser = userService.updateUserRunningResults(userId, updateRunningResults);
            return ResponseEntity.ok(updatedUser);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Add walking result
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/updateWalkingResults/{userId}")
    public ResponseEntity<?> updateWalking(@PathVariable("userId") String userId, @RequestBody UpdateWalkingResults updateWalkingResults) {
        try {
            User updatedUser = userService.updateUserWalkingResults(userId, updateWalkingResults);
            return ResponseEntity.ok(updatedUser);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Add biking result
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/updateBikingResults/{userId}")
    public ResponseEntity<?> updateBiking(@PathVariable("userId") String userId, @RequestBody UpdateBikingResults updateBikingResults) {
        try {
            User updatedUser = userService.updateUserBikingResults(userId, updateBikingResults);
            return ResponseEntity.ok(updatedUser);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
