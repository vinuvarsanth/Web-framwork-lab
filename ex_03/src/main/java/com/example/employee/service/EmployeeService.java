package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    public boolean saveEmployee(Employee employee){
        try{
            employeeRepo.save(employee);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee getEmployye (int id){
        return employeeRepo.findById(id).orElse(null);
    }
    public List<Employee> groupBy(){
        return employeeRepo.groupBy();
    }
    public Employee findByDesignation(String value){
        return employeeRepo.findByDesignation(value);
    }
    public List<Employee> getEmployeesBetween(int min, int max){
        return employeeRepo.getEmployeesBetween(min, max);
    }
}