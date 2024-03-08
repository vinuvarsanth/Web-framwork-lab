package com.employee.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employee.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByNameContaining(String name);
    public List<Employee> findAllByNameIsContaining(String name);
    public List<Employee> findAllByNameContains(String name);
    public List<Employee> findAllByNameStartsWith(String name);
    public List<Employee> findAllByNameEndsWith(String name);
}