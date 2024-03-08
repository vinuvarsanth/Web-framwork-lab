package com.employee.employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.Model.Employee;
import com.employee.employee.Repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepo employeeRepo;


    public boolean postData(Employee employee)
    {
        try{
            employeeRepo.save(employee);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }


    public List<Employee> getByStartWith(String name)
    {
        return employeeRepo.findAllByNameStartsWith(name);
    }
    public List<Employee> getByEndsWith(String name)
    {
        return employeeRepo.findAllByNameEndsWith(name);
    }
    public List<Employee> getByContains(String name)
    {
        return employeeRepo.findAllByNameContains(name);
    }
    public List<Employee> getByContaining(String name)
    {
        return employeeRepo.findAllByNameContaining(name);
    }
    public List<Employee> getByIsContaining(String name)
    {
        return employeeRepo.findAllByNameIsContaining(name);
    }
}
