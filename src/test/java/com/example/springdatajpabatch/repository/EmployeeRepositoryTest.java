package com.example.springdatajpabatch.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void testFindAllBetweenJoinAndExitDate() {
        var response = employeeRepository.findAllBetweenJoinAndExitDate(LocalDate.of(2022, 6, 16));
        assertEquals(2, response.size());
    }

    @Test
    void testJoinFetch() {
        var response = employeeRepository.fetchEmployeeJoinFetch(LocalDate.of(2013, 3, 15));
        assertEquals(1, response.size());
    }

}
