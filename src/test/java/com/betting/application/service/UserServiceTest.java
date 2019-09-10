package com.betting.application.service;

import com.betting.application.controller.error.UserNotFoundException;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.user.LoginDto;
import com.betting.application.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.transaction.Transactional;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        User user = new User("firstname", "lastname", "password", "email");
        userRepository.save(user);
        Long userId = user.getId();
        assertThat(user, sameBeanAs(userService.getUser(userId).get()));
    }

    @Test
    public void saveUser() {
        User user = new User("firstname", "lastname", "password", "email");
        userService.saveUser(user);
        Long userId = user.getId();
        Optional<User> user1 = userRepository.findById(userId);
        assertThat(user1.get(), sameBeanAs(user));
    }

    @Test
    public void loginUserWithCorrectCredentials() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        String randomString = new String(array, Charset.forName("UTF-8"));

        User user = new User("firstname", "lastname", randomString, randomString);
        userRepository.save(user);
        LoginDto loginDto = new LoginDto(randomString, randomString);
        userService.loginUser(loginDto);
        Assert.assertEquals(userRepository.findById(user.getId()).get().getLoggedIn(), true);
    }

    @Test
    public void loginUserWithNotCorrectCredentials() {

    }
}