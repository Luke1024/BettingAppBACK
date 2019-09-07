package com.betting.application.mapper;

import com.betting.application.domain.BetAccount;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import com.betting.application.domain.dto.BetAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BetAccountMapper {

    @Autowired
    private AccountHistoryPointMapper accountHistoryPointMapper;

    public BetAccountDto mapToBetAccountDto(BetAccount betAccount) {
        return new BetAccountDto(betAccount.getId(),
                betAccount.getUser(),
                betAccount.getAmount(),

                betAccount.getAccountHistoryPointList()
                        .stream().map(p -> new AccountHistoryPointDto(p.getPointId(),
                        p.getAccountBalanceChange(),
                        p.getMoneyAmountBeforeChange(),
                        p.getMoneyAmountAfterChange(),
                        p.getAccountChangeTime(),
                        p.getBetAccount(),
                        p.getTransaction())).collect(Collectors.toList()));
    }
}
