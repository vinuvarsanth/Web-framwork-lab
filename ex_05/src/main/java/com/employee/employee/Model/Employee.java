package com.employee.employee.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    private int id;
    private String name;
    private String designation;
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }
    

}
