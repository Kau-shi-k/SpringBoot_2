package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String message;

    @Embedded // Used to store User object as part of the Greeting entity
    private AuthUser authUser;

    public Greeting() {}

    public Greeting(String message, AuthUser authUser) {
        this.message = message;
        this.authUser = authUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthUser getUser() {
        return authUser;
    }

    public void setUser(AuthUser authUser) {
        this.authUser = authUser;
    }
}
