package com.backend.vitalvibe.services;

import com.backend.vitalvibe.models.Activity;
import com.backend.vitalvibe.payload.activity.CreateActivity;
import com.backend.vitalvibe.repositories.ActivityRepository;
import com.backend.vitalvibe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    public Activity createActivity(CreateActivity activity) {
        Activity newActivity = new Activity();
        newActivity.setActivityName(activity.getActivityName());
        newActivity.setDistance(activity.getDistance());
        newActivity.setTime(activity.getTime());
        newActivity.setCalories(activity.getCalories());
        newActivity.setMood(activity.getMood());

        return activityRepository.save(newActivity);
    }
}
