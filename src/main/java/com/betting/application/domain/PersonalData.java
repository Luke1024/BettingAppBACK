package com.betting.application.domain;

import javax.persistence.*;

@Entity
public class PersonalData {
    @Id
    @GeneratedValue
    private Long personalDataId;
    private String firstName;
    private String lastName;
    private String stateProvinceRegion;
    private String city;
    private String postalCode;
    private String adress;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BankAccount bankAccount;

    public PersonalData() {}

    public PersonalData(String firstName, String lastName, String stateProvinceRegion, String city, String postalCode, String adress, BankAccount bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateProvinceRegion = stateProvinceRegion;
        this.city = city;
        this.postalCode = postalCode;
        this.adress = adress;
        this.bankAccount = bankAccount;
    }

    public PersonalData(Long personalDataId, String firstName, String lastName, String stateProvinceRegion, String city, String postalCode, String adress, BankAccount bankAccount) {
        this.personalDataId = personalDataId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateProvinceRegion = stateProvinceRegion;
        this.city = city;
        this.postalCode = postalCode;
        this.adress = adress;
        this.bankAccount = bankAccount;
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
