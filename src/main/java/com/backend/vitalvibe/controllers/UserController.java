package com.backend.vitalvibe.controllers;

import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.User;
import com.backend.vitalvibe.payload.user.UpdateUser;
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
}
