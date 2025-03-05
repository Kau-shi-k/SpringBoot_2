package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID
    private int id;

    private String message;

    @Embedded
    private User user;

    public Greeting() {}

    public Greeting(String message, User user) {
        this.message = message;
        this.user = user;
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

    public User getUser(User user){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
