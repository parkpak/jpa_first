package com.example.jpa.web.controller.api;

import com.example.jpa.web.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeApiController {

    private final EmployeeService employeeService;

}
