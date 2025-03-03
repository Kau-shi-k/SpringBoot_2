package com.example.demo.Model;

public class Greeting {
    private String message;
    private int id;

    public Greeting(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
