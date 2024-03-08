package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Owner {
    @Id
    private int id;
    private String name;
    private String email;
    private String address;


    @JsonBackReference
    @OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
    private Asset asset;

}
