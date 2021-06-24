package com.example.jpa.web.dto.request;

import com.example.jpa.common.model.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class EmployeeRequest {

    private Long id;

    @NotEmpty
    private String firstName;

    private String lastName;

    public Employee toEntity() {
        return new Employee(firstName, lastName);
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
