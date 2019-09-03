package com.betting.application.controller;

import com.betting.application.domain.dto.UserActivityDto;
import com.betting.application.mapper.UserActivityMapper;
import com.betting.application.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class UserActivityController {

    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private UserActivityMapper userActivityMapper;

    @GetMapping(value = "/activity")
    public List<UserActivityDto> getUserActivity(@PathVariable Long userId){
        return userActivityMapper.mapToUserActivityDtoList(userActivityService.getUserActivity(userId));
    }
}
