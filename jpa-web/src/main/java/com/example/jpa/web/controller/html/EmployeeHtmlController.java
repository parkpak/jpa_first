package com.example.jpa.web.controller.html;

import com.example.jpa.web.dto.request.EmployeeRequest;
import com.example.jpa.common.model.entity.Employee;
import com.example.jpa.web.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

import static com.example.jpa.web.common.constant.HtmlUriConstant.*;
import static com.example.jpa.web.common.constant.ViewConstant.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class EmployeeHtmlController {

    private final EmployeeService employeeService;

    @GetMapping(URI_EMPLOYEE_LIST)
    public String lists(Model model) {

        List<Employee> employees = employeeService.getList();
        model.addAttribute("employees", employees);

        return VIEW_EMPLOYEE_LIST;
    }

    @GetMapping(URI_EMPLOYEE_VIEW)
    public String info(@PathVariable Long id, Model model) {    // IllegalArgumentException..

        log.info("id : " + id);
        Employee employee = employeeService.getById(id);        // IllegalArgumentException 발생..
        model.addAttribute("employee", employee);

        return VIEW_EMPLOYEE_VIEW;
    }

    @GetMapping(URI_EMPLOYEE_WRITE)
    public String create() {

        return VIEW_EMPLOYEE_WRITE;
    }

    @PostMapping(URI_EMPLOYEE_WRITE)
    public String store(@Valid EmployeeRequest employeeRequest,
                        BindingResult br) {   // bindException...

        log.info("**** " + employeeRequest.toString());

        if (br.hasErrors()) {
            throw new InvalidParameterException();  // invalidparameterexception...
        }

        employeeService.create(employeeRequest);

        return "redirect:" + URI_EMPLOYEE_LIST;
    }
}
