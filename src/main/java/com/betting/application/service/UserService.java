package com.betting.application.service;

import com.betting.application.controller.error.UserNotFoundException;
import com.betting.application.controller.error.UserNotLoggedInException;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.user.LoginDto;
import com.betting.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public boolean saveUser(User user){
        List<User> userByEmail = userRepository.retrieveUserByEmail(user.getEmail());
        if(userByEmail.isEmpty()) {
            userRepository.save(user);
            return true;
        } else return false;
    }

    public boolean loginUser(LoginDto loginDto)  {
        List<User> userByEmail = userRepository.retrieveUserByEmail(loginDto.getEmail());
        boolean correctRegistration;
        if(userByEmail.isEmpty()){
            correctRegistration = false;
        } else {
            User user = userByEmail.get(0);
            if(user.getPassword().equals(loginDto.getPassword())) {
                user.setLoggedIn(true);
                userRepository.save(user);
                correctRegistration = true;
            } else {
                correctRegistration = false;
            }
        }
        return correctRegistration;
    }

    public boolean logOutUser(Long userId) throws Exception {
        boolean logoutSuccess = false;
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User user1 = user.get();
            if (user1.getLoggedIn()==true) {
                user1.setLoggedIn(false);
                userRepository.save(user1);
                logoutSuccess = true;
            } else {
                throw new UserNotLoggedInException();
            }
        } else {
            throw new UserNotFoundException();
        }
        return logoutSuccess;
    }
}
