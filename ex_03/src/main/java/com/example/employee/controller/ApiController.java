package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
public class ApiController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add") // http://localhost:8080/add
    public Boolean saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/") // http://localhost:8080/
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}") // http://localhost:8080/4
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployye(id);

    }

    @GetMapping("/employees/groupBy") // http://localhost:8080/employees/groupBy
    public List<Employee> groupBy() {
        return employeeService.groupBy();
    }

    @GetMapping("/employees/findByDesignation") // http://localhost:8080/employees/findByDesignation?value=World King
    public Employee findBy(@RequestParam String value) {
        Employee emp = employeeService.findByDesignation(value);
        System.out.println(emp);
        return emp;
    }

    @GetMapping("/employees/salaryRange") // http://localhost:8080/employees/salaryRange?minSalary=30000&maxSalary=55000
    public List<Employee> getEmployeesBetween(@RequestParam int minSalary, @RequestParam int maxSalary) {
        return employeeService.getEmployeesBetween(minSalary, maxSalary);
    }
}
