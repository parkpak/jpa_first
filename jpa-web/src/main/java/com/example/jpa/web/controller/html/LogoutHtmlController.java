package com.example.jpa.web.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.jpa.web.common.constant.HtmlUriConstant.*;

@Controller
@RequestMapping(URI_LOGOUT)
public class LogoutHtmlController {

    @GetMapping
    public String userLogout() {

        return "redirect:" + URI_HOME;
    }
}
