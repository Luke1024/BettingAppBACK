package com.betting.application.mapper;

import com.betting.application.domain.PersonalData;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataDto;
import org.springframework.stereotype.Component;

@Component
public class PersonalDataMapper {
    public PersonalDataDto mapToBankAccountPersonalDataDto(PersonalData personalData){
        return new PersonalDataDto(personalData.getPersonalDataId(),
                personalData.getFirstName(),
                personalData.getLastName(),
                personalData.getStateProvinceRegion(),
                personalData.getCity(),
                personalData.getPostalCode(),
                personalData.getAdress());
    }
}
