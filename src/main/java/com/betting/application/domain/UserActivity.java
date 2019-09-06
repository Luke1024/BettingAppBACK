package com.betting.application.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserActivity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    private String activityType;
    private LocalDateTime localDateTime;

    public UserActivity() {}

    public UserActivity(Long id, User user, String activityType, LocalDateTime localDateTime) {
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
