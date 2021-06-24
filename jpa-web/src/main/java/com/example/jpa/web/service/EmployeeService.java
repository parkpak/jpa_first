package com.example.jpa.web.service;

import com.example.jpa.web.dto.request.EmployeeRequest;
import com.example.jpa.common.model.entity.Employee;
import com.example.jpa.common.model.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Employee getById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id Type Not Found " + id));

        return employee;
    }

    @Transactional(readOnly = true)
    public List<Employee> getList() {

        List<Employee> employees = employeeRepository.findAll();

        log.info(employees.toString());
        return employees;
    }

    @Transactional
    public Employee create(EmployeeRequest dto) {

        Employee employee = dto.toEntity();
        return employeeRepository.save(employee);
    }
}
