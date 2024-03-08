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
    public List<Employee> getNotContains( String name)
    {
        return employeeRepo.findAllByNameNotContains(name);
    }
    public List<Employee> getNotContaining( String name)
    {
        return employeeRepo.findAllByNameNotContaining(name);
    }
    public List<Employee> getNotLike( String name)
    {
        return employeeRepo.findAllByNameNotLike(name);
    }


}
