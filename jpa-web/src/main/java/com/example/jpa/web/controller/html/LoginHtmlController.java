package com.example.jpa.web.controller.html;

import com.example.jpa.web.dto.request.LoginRequest;
import com.example.jpa.web.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static com.example.jpa.web.common.constant.HtmlUriConstant.URI_LOGIN;
import static com.example.jpa.web.common.constant.ViewConstant.VIEW_HOME;
import static com.example.jpa.web.common.constant.ViewConstant.VIEW_LOGIN;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping(URI_LOGIN)
public class LoginHtmlController {

    private final LoginService loginService;

    @GetMapping
    public String LoginForm() {
        return VIEW_LOGIN;
    }

    @PostMapping
    public String Login(LoginRequest loginRequest, Model model, HttpServletRequest http) {

        loginRequest.setIp(http.getRemoteAddr());
        boolean login = loginService.login(loginRequest);
        if (login) {
            model.addAttribute("user", loginRequest);
        } else {
            return "redirect:" + URI_LOGIN;
        }

        return VIEW_HOME;
    }
}
