package com.example.springdatajpabatch.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class EmployeeCsv {
    @CsvBindByName(column = "first_name")
    private String firstName;
    @CsvBindByName(column = "last_name")
    private String lastName;
    @CsvBindByName(column = "date_of_birth")
    private String dateOfBirth;
}
