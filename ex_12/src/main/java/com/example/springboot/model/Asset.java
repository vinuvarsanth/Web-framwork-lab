package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Asset {
    @Id
    private int id;
    private String name;
    private String description;
    private double value;

    @JsonManagedReference
    @OneToOne
    private Owner owner;
}