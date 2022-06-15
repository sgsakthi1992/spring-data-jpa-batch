package com.example.springdatajpabatch.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeCsv {
    @CsvBindByName(column = "first_name")
    private String firstName;
    @CsvBindByName(column = "last_name")
    private String lastName;
    @CsvBindByName(column = "date_of_join")
    @CsvDate(value = "dd-MM-yyyy")
    private LocalDate dateOfJoin;
    @CsvBindByName(column = "date_of_exit")
    @CsvDate(value = "dd-MM-yyyy")
    private LocalDate dateOfExit;
}
