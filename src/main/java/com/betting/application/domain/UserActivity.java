package com.betting.application.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserActivity {
    @Id
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
