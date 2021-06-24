package com.example.jpa.common.model.repository;

import com.example.jpa.common.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByLastNameContaining(String string);
}

