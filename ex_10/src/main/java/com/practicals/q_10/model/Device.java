package com.practicals.q_10.model;

import java.util.Map;



import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private boolean status;

    @ElementCollection
    private Map<String, String> settings;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Device(int id, String name, String type, boolean status, Map<String, String> settings, User user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.settings = settings;
        this.user = user;
    }

    
    // Getters and setters
}
