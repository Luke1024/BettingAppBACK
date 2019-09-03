package com.betting.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BetDownloaderServiceTest {

    @Autowired
    private SportEventService betDownloaderService;

    @Test
    public void getAvailableBets() {
        betDownloaderService.downloadAvailableSportEvents();
    }
}