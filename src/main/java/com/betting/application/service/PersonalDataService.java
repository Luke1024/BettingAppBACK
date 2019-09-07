package com.betting.application.service;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.PersonalData;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataCreatorDto;
import com.betting.application.repository.BankAccountRepository;
import com.betting.application.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalDataService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private PersonalDataRepository personalDataRepository;

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
             personalDataRepository.save(mapToPersonalData(personalDataCreatorDto, bankAccount.get()));
         } else {}
    }

    public void updatePersonalData(PersonalDataCreatorDto personalDataCreatorDto) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(personalDataCreatorDto.getBankAccountId());
        if(bankAccount.isPresent()){
            personalDataRepository.save(
                    mapToPersonalDataUpdate(personalDataCreatorDto, bankAccount.get()));
        } else {}
    }

    private PersonalData mapToPersonalData(PersonalDataCreatorDto personalDataCreatorDto, BankAccount bankAccount){
        return new PersonalData(personalDataCreatorDto.getFirstName(),
                personalDataCreatorDto.getLastName(),
                personalDataCreatorDto.getStateProvinceRegion(),
                personalDataCreatorDto.getCity(),
                personalDataCreatorDto.getPostalCode(),
                personalDataCreatorDto.getAdress(),
                bankAccount);
    }

    private PersonalData mapToPersonalDataUpdate
            (PersonalDataCreatorDto personalDataCreatorDto, BankAccount bankAccount){
        return new PersonalData(bankAccount.getPersonalData().getPersonalDataId(),
                personalDataCreatorDto.getFirstName(),
                personalDataCreatorDto.getLastName(),
                personalDataCreatorDto.getStateProvinceRegion(),
                personalDataCreatorDto.getCity(),
                personalDataCreatorDto.getPostalCode(),
                personalDataCreatorDto.getAdress(),
                bankAccount);
    }
}
