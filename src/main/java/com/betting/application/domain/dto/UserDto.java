package com.betting.application.domain.dto;

public class UserDto {
    private String firstname;
    private String lastname;
    private String password;
    private String email;

    public UserDto() {}

    public UserDto(String firstname, String lastname, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
