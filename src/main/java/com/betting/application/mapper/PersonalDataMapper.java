package com.betting.application.mapper;

import com.betting.application.domain.BankAccountPersonalData;
import com.betting.application.domain.dto.bankaccountpersonaldata.BankAccountPersonalDataDto;
import org.springframework.stereotype.Component;

@Component
public class PersonalDataMapper {
    public BankAccountPersonalDataDto mapToBankAccountPersonalDataDto(BankAccountPersonalData bankAccountPersonalData){
        return new BankAccountPersonalDataDto(bankAccountPersonalData.getPersonalDataId(),
                bankAccountPersonalData.getFirstName(),
                bankAccountPersonalData.getLastName(),
                bankAccountPersonalData.getStateProvinceRegion(),
                bankAccountPersonalData.getCity(),
                bankAccountPersonalData.getPostalCode(),
                bankAccountPersonalData.getAdress());
    }
}
