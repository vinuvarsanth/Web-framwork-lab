package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.model.Employee;
import java.time.LocalDate;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByHireDate(LocalDate hire_date);
}
