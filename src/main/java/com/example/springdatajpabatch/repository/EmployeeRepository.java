package com.example.springdatajpabatch.repository;

import com.example.springdatajpabatch.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "from Employee e where :date BETWEEN e.dateOfJoin AND e.dateOfExit")
    List<Employee> findAllBetweenJoinAndExitDate(LocalDate date);
}
