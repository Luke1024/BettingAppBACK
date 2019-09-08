package com.betting.application.mapper;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.PersonalData;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.bankaccount.BankAccountDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankAccountMapperTest {

    @Autowired
    private BankAccountMapper bankAccountMapper;

    private BankAccount bankAccount = new BankAccount(1L, new PersonalData(),"name",
            "5555", new User(), new ArrayList<>(Arrays.asList(new Transaction())));
    private BankAccountDto bankAccountDto = new BankAccountDto(1L, new PersonalData(), "name", "5555",
            new User(), new ArrayList<>(Arrays.asList(new Transaction())));

    private List<BankAccount> bankAccountList = new ArrayList<>(Arrays.asList(bankAccount));
    private List<BankAccountDto> bankAccountDtoList = new ArrayList<>(Arrays.asList(bankAccountDto));

    @Test
    public void mapToBankAccountDtoList() {
        assertThat(bankAccountDtoList, sameBeanAs(bankAccountMapper.mapToBankAccountDtoList(bankAccountList)));
    }
}