package com.backend.vitalvibe.controllers;

import com.backend.vitalvibe.models.Activity;
import com.backend.vitalvibe.payload.activity.CreateActivity;
import com.backend.vitalvibe.payload.activity.UpdateActivity;
import com.backend.vitalvibe.services.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    // Add an activity
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> createActivity(@Valid @RequestBody CreateActivity activity) {
        try {
            return ResponseEntity.ok(activityService.createActivity(activity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // List all own activities
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/list-all/{userId}")
    public ResponseEntity<?> listAllActivities(@PathVariable("userId") String userId) {
        List<Activity> foundActivities = activityService.listAllActivities(userId);
        if (foundActivities.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activities not found");
        } else {
          return ResponseEntity.ok(foundActivities);
        }
    }

    // Delete an activity
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{activityId}")
    public ResponseEntity<?> deleteActivity(@PathVariable("activityId") String activityId) {
        return activityService.deleteActivity(activityId);
    }

    // Update an activity
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{activityId}")
    public ResponseEntity<?> updateActivity(@PathVariable("activityId") String activityId,
                                            @RequestBody UpdateActivity updateActivity) {
        Activity updatedActivity = activityService.updateActivity(activityId, updateActivity);
        return ResponseEntity.ok(updatedActivity);
    }
}
