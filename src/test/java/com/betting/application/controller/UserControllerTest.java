package com.betting.application.controller;

import com.betting.application.domain.User;
import com.betting.application.domain.dto.user.LoginDto;
import com.betting.application.domain.dto.user.UserDto;
import com.betting.application.mapper.UserMapper;
import com.betting.application.service.UserService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void registerUser() throws Exception {
        User user = new User(1L, "firstname", "lastname", "password", "email");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(user);

        when(userMapper.mapToUser(ArgumentMatchers.any(UserDto.class))).thenReturn(user);
        when(userService.saveUser(ArgumentMatchers.any(User.class))).thenReturn(true);

        mockMvc.perform(post("/betting/users")
                .contentType(APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void loginUser() throws Exception {
        LoginDto loginDto = new LoginDto("email", "password");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(loginDto);

        when(userService.loginUser(ArgumentMatchers.any(LoginDto.class))).thenReturn(true);

        mockMvc.perform(post("/betting/users/login")
        .contentType(APPLICATION_JSON)
        .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void logOutUser() {
    }

    @Test
    public void changeUserPassword() {
    }

    @Test
    public void deleteUser() {
    }
}