package com.student.student.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    private int id;
    private String Name;
    private int Age;
    private String Address;
    private String Department;
    public Student(int id, String name, int age, String address, String department) {
        this.id = id;
        this.Name = name;
        this.Age = age;
        this.Address = address;
        this.Department = department;
    }
    
}
