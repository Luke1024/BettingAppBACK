package com.betting.application.domain;

import java.time.LocalDateTime;

public class AccountHistoryPoint {
    private Long historical_point_id;
    private double account_change;
    private double money_amount_before_change;
    private double money_amount_after_change;
    private LocalDateTime account_change_time;
}
