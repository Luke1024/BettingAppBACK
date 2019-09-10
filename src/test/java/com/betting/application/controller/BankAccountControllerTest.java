package com.betting.application.controller;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.PersonalData;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.bankaccount.BankAccountCreationDto;
import com.betting.application.domain.dto.bankaccount.BankAccountDto;
import com.betting.application.domain.dto.bankaccount.BankAccountUpdaterDto;
import com.betting.application.mapper.BankAccountMapper;
import com.betting.application.service.BankAccountService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest(BankAccountController.class)
public class BankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankAccountService bankAccountService;

    @MockBean
    private BankAccountMapper bankAccountMapper;

    private BankAccount bankAccount = new BankAccount(1L, "name", "5555", new User());
    private BankAccountDto bankAccountDto = new BankAccountDto(1L, new PersonalData(), "name", "5555",
            new User(), new ArrayList<>(Arrays.asList(new Transaction())));
    private BankAccountCreationDto bankAccountCreationDto = new BankAccountCreationDto("name", "5555", 1L);
    private BankAccountUpdaterDto bankAccountUpdaterDto = new BankAccountUpdaterDto(1L, "name", "5555", 1L);

    private Gson gson = new Gson();
    private String creationDtoInJson = gson.toJson(bankAccountCreationDto);

    private String updaterDtoInJson = gson.toJson(bankAccountUpdaterDto);

    @Test
    public void getUserBankAccountController() throws Exception {
        when(bankAccountService.getUserBankAccounts(ArgumentMatchers.anyLong())).thenReturn(new ArrayList<>(Collections.singletonList(bankAccount)));
        when(bankAccountMapper.mapToBankAccountDtoList(ArgumentMatchers.anyList())).thenReturn(new ArrayList<>(Collections.singletonList(bankAccountDto)));
        mockMvc.perform(get("/betting/userBankAccount/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].bankAccountId", is(1)))
                .andExpect(jsonPath("$[0].bankName", is("name")))
                .andExpect(jsonPath("$[0].bankNumber", is("5555")));
    }

    @Test
    public void createUserBankAccount() throws Exception {
        mockMvc.perform(post("/betting/userBankAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(creationDtoInJson))
                .andExpect(status().isOk());
    }

    @Test
    public void updateUserBankAccount() throws Exception {
        mockMvc.perform(put("/betting/userBankAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(updaterDtoInJson))
                .andExpect(status().isOk());
    }
}