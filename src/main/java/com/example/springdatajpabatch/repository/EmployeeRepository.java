package com.example.springdatajpabatch.repository;

import com.example.springdatajpabatch.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDateOfJoinBetweenAndDateOfExitBetween(LocalDate startJoinDate, LocalDate endJoinDate, LocalDate startExitDate, LocalDate endExitDate);
}
