package com.betting.application.mapper;

import com.betting.application.domain.User;
import com.betting.application.domain.dto.user.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapToUser() {
        User user = new User("firstname", "lastname", "password", "email");
        UserDto userDto = new UserDto("firstname", "lastname", "password", "email");

        assertThat(user, sameBeanAs(userMapper.mapToUser(userDto)));
    }
}