package com.example.jpa.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

    private String email;

    private String password;

    private String ip;
}
