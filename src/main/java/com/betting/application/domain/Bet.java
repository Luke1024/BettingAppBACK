package com.betting.application.domain;

import com.betting.application.domain.utilities.Result;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

public class Bet {
    private Long betId;
    private Long userId;
    private Long matchId;
    private Long amount;
    private Result bet;
    private Result result;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private double amoutChangeAfterClosing;
    private LocalDateTime open;
    private LocalDateTime lastEdit;
    private User user;


}
