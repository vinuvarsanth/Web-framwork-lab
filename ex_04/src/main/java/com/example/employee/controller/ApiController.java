package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

import java.util.List;
import java.time.LocalDate;

@RestController
public class ApiController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/") // http://localhost:8080/
    public boolean addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/{id}") // http://localhost:8080/6
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/") // http://localhost:8080/
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/first-three-characters-of-first-name") // http://localhost:8080/employees/first-three-characters-of-first-name
    public List<String> getFirstThreeCharactersOfFirstName() {
        return employeeService.getFirstThreeCharactersOfFirstName();
    }
    @GetMapping("/employees/hired/{hireDate}") // http://localhost:8080/employees/hired/2024-03-07
    public List<Employee> getEmployeesHiredOnDate(@PathVariable("hireDate") LocalDate hireDate) {
        return employeeService.getEmployeesHiredOnDate(hireDate);
    }
}
