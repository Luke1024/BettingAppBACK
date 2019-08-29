package com.betting.application.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class BetAccount {
    @Id
    @GeneratedValue
    private Long id;
    private User user;
    private double amount;
    private List<AccountHistoryPoint> accountHistoryPointList;
}
