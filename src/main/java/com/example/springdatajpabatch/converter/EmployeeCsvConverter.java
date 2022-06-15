package com.example.springdatajpabatch.converter;

import com.example.springdatajpabatch.model.EmployeeCsv;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class EmployeeCsvConverter {
    public List<EmployeeCsv> convert() throws FileNotFoundException {
        var file = "src/main/resources/employees.csv";
        return new CsvToBeanBuilder<EmployeeCsv>(new FileReader(file))
                .withType(EmployeeCsv.class)
                .build()
                .parse();
    }
}
