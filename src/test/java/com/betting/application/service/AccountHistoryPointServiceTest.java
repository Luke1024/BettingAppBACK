package com.betting.application.service;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BetAccount;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;
import com.betting.application.repository.AccountHistoryPointRepository;
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
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountHistoryPointServiceTest {

    @Autowired
    private AccountHistoryPointService accountHistoryPointService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountHistoryPointRepository accountHistoryPointRepository;

    @Test
    public void getUserAccountHistoryPoints() throws Exception {
        BetAccount betAccount = new BetAccount();
        Transaction transaction = new Transaction();

        User user = new User();
        AccountHistoryPoint accountHistoryPoint = new AccountHistoryPoint(
                50.50, 0.00, 50.00,
                LocalDateTime.now(), betAccount, transaction);

        user.setBetAccount(betAccount);
        user.setId(5L);

        betAccount.setUser(user);

        accountHistoryPoint.setBetAccount(betAccount);
        betAccount.getAccountHistoryPointList().add(accountHistoryPoint);

        accountHistoryPointRepository.save(accountHistoryPoint);

        System.out.println(accountHistoryPoint.getPointId());
    }
}