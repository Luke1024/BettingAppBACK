package com.betting.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.util.List;

@NamedNativeQuery(
        name = "User.retrieveUserByEmail",
        query = "SELECT * FROM betting_app.user WHERE email = :EMAIL",
        resultClass = User.class
)
@NamedNativeQuery(
        name = "User.retrieveUserByPassword",
        query = "SELECT * FROM betting_app.user WHERE password = :PASSWORD",
        resultClass = User.class
)

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private List<Bet> bets;
    private List<Bet> betsArchive;
    private BetAccount account;

    public User() {}

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public User(Long id ,String firstName, String lastName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
