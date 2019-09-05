package com.betting.application.mapper;

import com.betting.application.domain.User;
import com.betting.application.domain.dto.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto){
        return new User(userDto.getFirstname(), userDto.getLastname(), userDto.getPassword(), userDto.getEmail());
    }
}
