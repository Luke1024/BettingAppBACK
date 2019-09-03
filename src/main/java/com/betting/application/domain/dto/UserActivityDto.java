package com.betting.application.domain.dto;

import com.betting.application.domain.User;

import java.time.LocalDateTime;

public class UserActivityDto {
    private Long id;
    private User user;
    private String activityType;
    private LocalDateTime localDateTime;

    public UserActivityDto(Long id, User user, String activityType, LocalDateTime localDateTime) {
        this.id = id;
        this.user = user;
        this.activityType = activityType;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getActivityType() {
        return activityType;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
