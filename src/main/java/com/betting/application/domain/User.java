package com.betting.application.domain;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(
            targetEntity = Bet.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Bet> bets;
    @OneToMany(
            targetEntity = UserActivity.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<UserActivity> userActivity;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BetAccount account;
    @OneToMany(
            targetEntity = BankAccount.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BankAccount> bankAccounts;
    @OneToMany(
            targetEntity = Note.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Note> notes;

    public User() {}

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userActivity = new ArrayList<>();
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

    public List<Bet> getBets() {
        return bets;
    }

    public List<UserActivity> getUserActivity() {
        return userActivity;
    }

    public BetAccount getBetAccount() {
        return account;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public BetAccount getAccount() {
        return account;
    }

    public List<Note> getNotes() {
        return notes;
    }
}
