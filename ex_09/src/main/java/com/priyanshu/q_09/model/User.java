package com.priyanshu.q_09.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id

    private int id;
    private String username;
    private String email;

}
