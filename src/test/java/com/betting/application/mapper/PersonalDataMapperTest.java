package com.betting.application.mapper;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.PersonalData;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalDataMapperTest {

    @Autowired
    private PersonalDataMapper personalDataMapper;

    private PersonalData personalData = new PersonalData(1L, "firstname", "lastname",
            "region", "city", "postalCode", "adress", new BankAccount());
    private PersonalDataDto personalDataDto = new PersonalDataDto(1L, "firstname", "lastname",
            "region", "city", "postalCode", "adress");

    @Test
    public void mapToBankAccountPersonalDataDto() {
        assertThat(personalDataDto, sameBeanAs(personalDataMapper.mapToBankAccountPersonalDataDto(personalData)));
    }
}