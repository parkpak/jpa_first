package com.example.jpa.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.example.jpa.web.common.constant.HtmlUriConstant.*;
import static com.example.jpa.web.common.constant.ViewConstant.*;

@Controller
public class MainController {

    @GetMapping(URI_HOME)
    public String main() {

        return VIEW_HOME;
    }
}
