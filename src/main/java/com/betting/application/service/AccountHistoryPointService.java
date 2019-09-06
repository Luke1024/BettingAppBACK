package com.betting.application.service;

import com.betting.application.controller.error.UserNotFoundException;
import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.User;
import com.betting.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountHistoryPointService {

    @Autowired
    private UserRepository userRepository;

    public List<AccountHistoryPoint> getUserAccountHistoryPoints(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        List<AccountHistoryPoint> accountHistoryPoints = new ArrayList<>();
        if(user.isPresent()){
            accountHistoryPoints = user.get().getBetAccount().getAccountHistoryPointList();
        } else {
            throw new UserNotFoundException();
        }
        return accountHistoryPoints;
    }
}
