package com.betting.application.service;

import com.betting.application.domain.User;
import com.betting.application.domain.UserActivity;
import com.betting.application.repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserActivityService {
    @Autowired
    private UserService userService;

    public List<UserActivity> getUserActivity(Long userId) {
        Optional<User> user = userService.getUser(userId);
        List<UserActivity> userActivities = new ArrayList<>();
        if(user.isPresent()){
            userActivities = user.get().getUserActivity();
        }
        return userActivities;
    }
}
