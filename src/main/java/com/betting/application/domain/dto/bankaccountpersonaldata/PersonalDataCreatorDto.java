package com.betting.application.domain.dto.bankaccountpersonaldata;

public class PersonalDataCreatorDto {
    private Long bankAccountId;
    private String firstName;
    private String lastName;
    private String stateProvinceRegion;
    private String city;
    private String postalCode;
    private String adress;

    public PersonalDataCreatorDto(Long bankAccountId, String firstName, String lastName, String stateProvinceRegion, String city, String postalCode, String adress) {
        this.bankAccountId = bankAccountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateProvinceRegion = stateProvinceRegion;
        this.city = city;
        this.postalCode = postalCode;
        this.adress = adress;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStateProvinceRegion() {
        return stateProvinceRegion;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAdress() {
        return adress;
    }
}
