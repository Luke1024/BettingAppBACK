package com.betting.application.controller;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BankAccount;
import com.betting.application.domain.dto.transaction.TransactionCreatorDto;
import com.betting.application.domain.dto.transaction.TransactionDto;
import com.betting.application.domain.utilities.PaymentDirection;
import com.betting.application.service.TransactionService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void getUserTransactions() throws Exception {
        TransactionDto transactionDto = new TransactionDto(1L, new AccountHistoryPoint(), PaymentDirection.INCOMING, 50.5, new BankAccount());

        List<TransactionDto> transactionDtos = new ArrayList<>(Arrays.asList(transactionDto));

        when(transactionService.getUserTransactions(ArgumentMatchers.anyLong())).thenReturn(transactionDtos);

        mockMvc.perform(get("/betting/userTransactions/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].transactionId", is(1)))
                .andExpect(jsonPath("$[0].amount", is(50.5)));
    }

    @Test
    public void createTransaction() throws Exception {
        TransactionCreatorDto transactionCreatorDto =
                new TransactionCreatorDto(PaymentDirection.INCOMING, 50.5, 1L);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(transactionCreatorDto);

        mockMvc.perform(post("/betting/userTransactions")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}