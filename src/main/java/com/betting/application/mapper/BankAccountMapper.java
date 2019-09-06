package com.betting.application.mapper;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.dto.bankaccount.BankAccountDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BankAccountMapper {
    public List<BankAccountDto> mapToBankAccountDtoList(List<BankAccount> bankAccountList){
        return bankAccountList.stream().map(a -> new BankAccountDto(a.getBankAccountId(), a.getPersonalData(),
                a.getBankName(), a.getBankNumber(), a.getUser(), a.getTransactions())).collect(Collectors.toList());
    }
}
