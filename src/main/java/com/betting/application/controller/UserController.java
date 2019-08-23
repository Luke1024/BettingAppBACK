package com.betting.application.controller;

import com.betting.application.domain.dto.UserDto;
import com.betting.application.mapper.UserMapper;
import com.betting.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/betting")
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody UserDto userDto){
        LOGGER.info("Saving user: " + userDto.getFirstname() + " " + userDto.getLastname());
        System.out.println(userDto.getFirstname() + " " + userDto.getLastname() + " " + userDto.getPassword() + " " + userDto.getEmail());
        userService.saveUser(userMapper.mapToUser(userDto));
    }
}
