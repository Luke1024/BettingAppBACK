package com.betting.application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccountPersonalData {
    @Id
    private Long personalDataId;
    private String firstName;
    private String lastName;
    private String stateProvinceRegion;
    private String city;
    private String postalCode;
    private String adress;

    public BankAccountPersonalData() {}

    public BankAccountPersonalData(String firstName, String lastName, String stateProvinceRegion, String city, String postalCode, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateProvinceRegion = stateProvinceRegion;
        this.city = city;
        this.postalCode = postalCode;
        this.adress = adress;
    }

    public Long getPersonalDataId() {
        return personalDataId;
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