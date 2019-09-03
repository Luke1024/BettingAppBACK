package com.betting.application.service;

import com.betting.application.domain.User;
import com.betting.application.domain.dto.LoginDto;
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

    public boolean loginUser(LoginDto loginDto){
        List<User> userByEmail = userRepository.retrieveUserByEmail(loginDto.getEmail());
        boolean correctRegistration;
        if(userByEmail.isEmpty()){
            correctRegistration = false;
        } else {
            if (userByEmail.get(0).getPassword().equals(loginDto.getPassword())) {
                correctRegistration = true;
            } else {
                correctRegistration = false;
            }
        }
        return correctRegistration;
    }
}
