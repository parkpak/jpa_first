package com.example.jpa.web.controller.html;

import com.example.jpa.web.dto.request.RegisterRequest;
import com.example.jpa.web.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.jpa.web.common.constant.HtmlUriConstant.*;
import static com.example.jpa.web.common.constant.ViewConstant.*;

@Slf4j
@Controller
@RequestMapping(URI_REGISTER)
public class RegisterHtmlController {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public String registerForm() {

        return VIEW_REGISTER;
    }

    @PostMapping
    public String registerUser(RegisterRequest registerRequest) {

        log.debug(registerRequest.toString());

        registerService.register(registerRequest);

        return "redirect:" + URI_HOME;
    }
}
