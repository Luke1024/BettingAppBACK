package com.betting.application.controller;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.PersonalData;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataCreatorDto;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataDto;
import com.betting.application.mapper.PersonalDataMapper;
import com.betting.application.service.PersonalDataService;
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

@RunWith(SpringRunner.class)
@WebMvcTest(PersonalDataController.class)
public class PersonalDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonalDataMapper personalDataMapper;

    @MockBean
    private PersonalDataService personalDataService;

    private PersonalDataCreatorDto personalDataCreatorDto =
            new PersonalDataCreatorDto(1L, "firstname", "lastname",
                    "region", "city", "postalcode", "adress");
    private Gson gson = new Gson();
    private String jsonContent = gson.toJson(personalDataCreatorDto);

    @Test
    public void getBankAccountPersonalData() throws Exception {
        PersonalData personalData = new PersonalData(1L, "firstname", "lastname",
                "region", "city", "postalCode", "adress", new BankAccount());
        PersonalDataDto personalDataDto = new PersonalDataDto(1L, "firstname", "lastname",
                "region", "city", "postalCode", "adress");

        when(personalDataService.getUserBankAccountPersonalData(ArgumentMatchers.anyLong()))
                .thenReturn(personalData);
        when(personalDataMapper.mapToBankAccountPersonalDataDto(ArgumentMatchers.any(PersonalData.class)))
                .thenReturn(personalDataDto);

        mockMvc.perform(get("/betting/personalData/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.personalDataId", is(1)))
                .andExpect(jsonPath("$.firstName", is("firstname")))
                .andExpect(jsonPath("$.lastName", is("lastname")))
                .andExpect(jsonPath("$.stateProvinceRegion", is("region")))
                .andExpect(jsonPath("$.city", is("city")))
                .andExpect(jsonPath("$.postalCode", is("postalCode")))
                .andExpect(jsonPath("$.adress", is("adress")));
    }

    @Test
    public void createBankAccountPersonalData() throws Exception {
        mockMvc.perform(post("/betting/personalData")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void updateBankAccountPersonalData() throws Exception {
        mockMvc.perform(put("/betting/personalData")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}