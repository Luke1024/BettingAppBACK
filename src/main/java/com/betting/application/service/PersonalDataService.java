package com.betting.application.service;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.PersonalData;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataCreatorDto;
import com.betting.application.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalDataService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public PersonalData getUserBankAccountPersonalData(Long accountId) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(accountId);
        PersonalData personalData = null;
        if(bankAccount.isPresent()){
            personalData = bankAccount.get().getPersonalData();
        } else {}
        return personalData;
    }

    public void createPersonalData(PersonalDataCreatorDto personalDataCreatorDto) {
         Optional<BankAccount> bankAccount = bankAccountRepository.findById(personalDataCreatorDto.getBankAccountId());
         if(bankAccount.isPresent()){
             bankAccount.get().setPersonalData(
                     new PersonalData(personalDataCreatorDto.getFirstName(),
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
            Long personalDataId = bankAccount.get().getPersonalData().getPersonalDataId();
            bankAccount.get().setPersonalData(new PersonalData(
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
