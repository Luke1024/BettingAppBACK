package com.betting.application.mapper;

import com.betting.application.domain.UserActivity;
import com.betting.application.domain.dto.UserActivityDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserActivityMapper {
    public List<UserActivityDto> mapToUserActivityDtoList(List<UserActivity> userActivities){
        return userActivities.stream()
                .map(a -> new UserActivityDto(a.getId(), a.getUser(), a.getActivityType(), a.getLocalDateTime()))
                .collect(Collectors.toList());
    }
}
