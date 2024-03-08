package com.employee.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employee.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByNameNotLike(String name);
    public List<Employee> findAllByNameNotContains(String name);
    public List<Employee> findAllByNameNotContaining(String name);
}