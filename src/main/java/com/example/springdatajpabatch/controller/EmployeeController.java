package com.example.springdatajpabatch.controller;

import com.example.springdatajpabatch.domain.Employee;
import com.example.springdatajpabatch.model.HeaderRequest;
import com.example.springdatajpabatch.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public void saveAll() throws FileNotFoundException {
        employeeService.saveAll();
    }

    @GetMapping("/between")
    public List<Employee> findBetween(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return employeeService.findBetween(date);
    }
    @GetMapping("/json-header")
    public HeaderRequest requestHeaderJson(@RequestHeader("jsonHeader") HeaderRequest jsonHeader) {
        return jsonHeader;
    }

}
