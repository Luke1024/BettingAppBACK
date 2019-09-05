package com.betting.application.controller;
import com.betting.application.domain.dto.user.LoginDto;
import com.betting.application.domain.dto.user.UserDto;
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
    public boolean registerUser(@RequestBody UserDto userDto){
        LOGGER.info("Saving user: " + userDto.getFirstname() + " " + userDto.getLastname() + " " + userDto.getPassword() + " " + userDto.getEmail());
        return userService.saveUser(userMapper.mapToUser(userDto));
    }

    @PostMapping(value = "/users/login", consumes = APPLICATION_JSON_VALUE)
    public boolean loginUser(@RequestBody LoginDto loginDto){
        LOGGER.info("Logging user with email: " + loginDto.getEmail());
        return userService.loginUser(loginDto);
    }

    @PostMapping(value = "/users/logout", consumes = APPLICATION_JSON_VALUE)
    public void logOutUser(@RequestBody LoginDto loginDto){
        LOGGER.info("Logout user with email: " + loginDto.getEmail() + " " + loginDto.getPassword());
    }

    @PutMapping(value = "users/password", consumes = APPLICATION_JSON_VALUE)
    public void changeUserPassword(@RequestBody LoginDto loginDto){
        LOGGER.info("Changing user password to: " + loginDto.getPassword());
    }

    @PutMapping(value = "users/block")

    @DeleteMapping(value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestBody LoginDto loginDto){
        LOGGER.info("Delete user with email: " + loginDto.getEmail() + " " + loginDto.getPassword());
    }
}
