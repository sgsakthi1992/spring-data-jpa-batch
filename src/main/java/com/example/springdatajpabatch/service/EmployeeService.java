package com.example.springdatajpabatch.service;

import com.example.springdatajpabatch.converter.EmployeeConverter;
import com.example.springdatajpabatch.converter.EmployeeCsvConverter;
import com.example.springdatajpabatch.domain.Employee;
import com.example.springdatajpabatch.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeCsvConverter employeeCsvConverter;
    private final EmployeeConverter employeeConverter;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeCsvConverter employeeCsvConverter, EmployeeConverter employeeConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeCsvConverter = employeeCsvConverter;
        this.employeeConverter = employeeConverter;
    }

    public void saveAll() throws FileNotFoundException {
        employeeRepository.saveAll(employeeConverter.convert(employeeCsvConverter.convert()));
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findBetween(LocalDate dateOfJoin, LocalDate dateOfExit) {
        return employeeRepository.findByDateOfJoinBetweenAndDateOfExitBetween(dateOfJoin, dateOfExit, dateOfJoin, dateOfExit);
    }
}
