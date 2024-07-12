package com.backend.vitalvibe.services;

import com.backend.vitalvibe.exceptions.EntityNotFoundException;
import com.backend.vitalvibe.models.Activity;
import com.backend.vitalvibe.payload.activity.CreateActivity;
import com.backend.vitalvibe.payload.activity.UpdateActivity;
import com.backend.vitalvibe.repositories.ActivityRepository;
import com.backend.vitalvibe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    // Add a activity
    public ResponseEntity<?> createActivity(CreateActivity activity) {
        Activity newActivity = new Activity();
        newActivity.setUserId(activity.getUserId());
        newActivity.setActivityName(activity.getActivityName());
        newActivity.setDistance(activity.getDistance());
        newActivity.setTime(activity.getTime());
        newActivity.setCalories(activity.getCalories());
        newActivity.setMood(activity.getMood());

        activityRepository.save(newActivity);
        return ResponseEntity.ok("Activity was created!");
    }

    // List all activities of a user
    public List<Activity> listAllActivities(String userId) {
        return activityRepository.findByUserId(userId);
    }

    // Delete an activity
    public ResponseEntity<?> deleteActivity(String activityId) {
        if (activityRepository.existsById(activityId)) {
            activityRepository.deleteById(activityId);
            return ResponseEntity.ok("Activity deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found");
        }
    }

    // Update an activity
    public Activity updateActivity(String activityId, UpdateActivity updateActivity) {
        return activityRepository.findById(activityId).map(exisitngActivity -> {
            Optional.ofNullable(updateActivity.getActivityName()).ifPresent(exisitngActivity::setActivityName);
            Optional.ofNullable(updateActivity.getDistance()).ifPresent(exisitngActivity::setDistance);
            Optional.ofNullable(updateActivity.getTime()).ifPresent(exisitngActivity::setTime);
            Optional.ofNullable(updateActivity.getCalories()).ifPresent(exisitngActivity::setCalories);
            Optional.ofNullable(updateActivity.getMood()).ifPresent(exisitngActivity::setMood);

            return activityRepository.save(exisitngActivity);
        }).orElseThrow(() -> new EntityNotFoundException("Activity with id " + activityId + " not found"));
    }
}
