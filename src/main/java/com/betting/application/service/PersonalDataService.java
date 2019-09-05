package com.betting.application.service;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.BankAccountPersonalData;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataCreatorDto;
import com.betting.application.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalDataService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccountPersonalData getUserBankAccountPersonalData(Long accountId) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(accountId);
        BankAccountPersonalData bankAccountPersonalData = null;
        if(bankAccount.isPresent()){
            bankAccountPersonalData = bankAccount.get().getBankAccountPersonalData();
        } else {}
        return bankAccountPersonalData;
    }

    public void createPersonalData(PersonalDataCreatorDto personalDataCreatorDto) {
         Optional<BankAccount> bankAccount = bankAccountRepository.findById(personalDataCreatorDto.getBankAccountId());
         if(bankAccount.isPresent()){
             bankAccount.get().setBankAccountPersonalData(
                     new BankAccountPersonalData(personalDataCreatorDto.getFirstName(),
                             personalDataCreatorDto.getLastName(),
                             personalDataCreatorDto.getStateProvinceRegion(),
                             personalDataCreatorDto.getCity(),
                             personalDataCreatorDto.getPostalCode(),
                             personalDataCreatorDto.getAdress()));
             bankAccountRepository.save(bankAccount.get());
         } else {}
    }

    public void updatePersonalData(PersonalDataCreatorDto personalDataCreatorDto) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(personalDataCreatorDto.getBankAccountId());
        if(bankAccount.isPresent()){
            Long personalDataId = bankAccount.get().getBankAccountPersonalData().getPersonalDataId();
            bankAccount.get().setBankAccountPersonalData(new BankAccountPersonalData(
                    personalDataId,
                    personalDataCreatorDto.getFirstName(),
                    personalDataCreatorDto.getLastName(),
                    personalDataCreatorDto.getStateProvinceRegion(),
                    personalDataCreatorDto.getCity(),
                    personalDataCreatorDto.getPostalCode(),
                    personalDataCreatorDto.getAdress()
            ));
        }
    }
}
