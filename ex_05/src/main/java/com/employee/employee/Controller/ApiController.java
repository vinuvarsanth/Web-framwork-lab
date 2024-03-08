package com.employee.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.Model.Employee;
import com.employee.employee.Service.EmployeeService;

@RestController
public class ApiController {
    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/") // http://localhost:8080/
    public Employee postData(@RequestBody Employee employee)
    {
        employeeService.postData(employee);
        return employee;
    }

    @GetMapping("/getstart/{name}") // http://localhost:8080/getstart/jack
    public List<Employee> getStartWith(@PathVariable String name)
    {
        return employeeService.getByStartWith(name);
    }
    @GetMapping("/getends/{name}") // http://localhost:8080/getends/taylor
    public List<Employee> getEndsWith(@PathVariable String name)
    {
        return employeeService.getByEndsWith(name);
    }
    @GetMapping("/getcontains/{name}") // http://localhost:8080/getcontains/ch
    public List<Employee> getContains(@PathVariable String name)
    {
        return employeeService.getByContains(name);
    }
    @GetMapping("/getcontaining/{name}") // http://localhost:8080/getcontaining/brown
    public List<Employee> getContaining(@PathVariable String name)
    {
        return employeeService.getByContaining(name);
    }
    @GetMapping("/getIscontaining/{name}") // http://localhost:8080/getIscontaining/daniel
    public List<Employee> getIsContaining(@PathVariable String name)
    {
        return employeeService.getByIsContaining(name);
    }
}
