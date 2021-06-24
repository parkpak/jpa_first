package com.example.jpa.web.dto.request;

import com.example.jpa.common.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequest {

    private String email;

    private String name;

    private String password;

    public User toEntity() {

        return new User(email, password, name);
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
