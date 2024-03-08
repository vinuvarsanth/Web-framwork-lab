package com.example.employee.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepo;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public boolean addEmployee(Employee employee) {
        try{
            employeeRepo.save(employee);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
    public List<String> getFirstThreeCharactersOfFirstName() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employee -> employee.getName().substring(0, Math.min(employee.getName().length(), 3)))
                .collect(Collectors.toList());
    }
    public List<Employee> getEmployeesHiredOnDate(LocalDate hireDate) {
        return employeeRepo.findByHireDate(hireDate);
    }
}