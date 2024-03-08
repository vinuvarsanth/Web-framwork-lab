package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employee.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    @Query(value = "Select * from employee group by designation,salary,id", nativeQuery = true)
    public List<Employee> groupBy();
    @Query("Select e from Employee e where e.designation = ?1")
    public Employee findByDesignation(String value); 
    @Query(value = "Select * from employee where salary between ?1 and ?2", nativeQuery = true)
    public List<Employee> getEmployeesBetween(int min, int max);
}
