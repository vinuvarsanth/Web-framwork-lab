package com.student.student.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Donor {
    @Id
    private int id;
    private String Name;
    private int Age;
    private String Address;
    private String Bloodgroup;
    public Donor(int id, String name, int age, String address, String bloodgroup) {
        this.id = id;
        Name = name;
        Age = age;
        Address = address;
        Bloodgroup = bloodgroup;
    }
    
    
}
