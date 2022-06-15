package com.example.springdatajpabatch.converter;

import com.example.springdatajpabatch.domain.Employee;
import com.example.springdatajpabatch.model.EmployeeCsv;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeConverter {
    public List<Employee> convert(List<EmployeeCsv> employeeCsvList) {
        return employeeCsvList.parallelStream()
                .map(this::createEmployee)
                .collect(Collectors.toList());
    }

    private Employee createEmployee(EmployeeCsv employeeCsv) {
        var employee = new Employee();
        employee.setFirstName(employeeCsv.getFirstName());
        employee.setLastName(employeeCsv.getLastName());
        employee.setDateOfJoin(employeeCsv.getDateOfJoin());
        employee.setDateOfExit(employeeCsv.getDateOfExit());
        return employee;
    }
}
