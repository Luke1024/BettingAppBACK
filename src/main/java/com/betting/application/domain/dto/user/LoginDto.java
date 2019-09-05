package com.betting.application.domain.dto.user;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto() {}

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
