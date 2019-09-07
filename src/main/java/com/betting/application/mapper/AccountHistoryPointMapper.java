package com.betting.application.mapper;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountHistoryPointMapper {
    public List<AccountHistoryPointDto> mapToAccountHistoryPointList(List<AccountHistoryPoint> accountHistoryPoints) {
        return accountHistoryPoints.stream().map(p -> new AccountHistoryPointDto(p.getPointId(),
                p.getAccountBalanceChange(),
                p.getMoneyAmountBeforeChange(),
                p.getMoneyAmountAfterChange(),
                p.getAccountChangeTime(),
                p.getBetAccount(),
                p.getTransaction())).collect(Collectors.toList());
    }
}
