package com.betting.application.domain;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Note() {
    }

    public Note(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public Note(Long id, String content, User user) {
        this.id = id;
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }
}
