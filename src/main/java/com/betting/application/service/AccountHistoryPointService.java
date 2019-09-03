package com.betting.application.service;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountHistoryPointService {

    @Autowired
    private UserRepository userRepository;

    public List<AccountHistoryPoint> getUserAccountHistoryPoints(Long userId){
        return userRepository.findById(userId).get().getBetAccount().getAccountHistoryPointList();
    }
}
