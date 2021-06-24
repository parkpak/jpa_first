package com.example.jpa.web.common.event;

public class RegisteredEvent {

    private String email;

    private String name;

    public RegisteredEvent() {

    }

    public RegisteredEvent(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
