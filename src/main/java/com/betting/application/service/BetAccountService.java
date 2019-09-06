package com.betting.application.service;

import com.betting.application.domain.BetAccount;
import com.betting.application.domain.User;
import com.betting.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BetAccountService {

    @Autowired
    private UserRepository userRepository;

    public BetAccount getBetAccount(Long userId){
        Optional<User> user = userRepository.findById(userId);
        BetAccount betAccount = null;
        if(user.isPresent()) {
            betAccount = user.get().getBetAccount();
        } else { }
        return betAccount;
    }
}
