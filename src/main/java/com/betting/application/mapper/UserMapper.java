package com.betting.application.mapper;

import com.betting.application.domain.User;
import com.betting.application.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto){
        return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getPassword(), userDto.getEmail());
    }
}
