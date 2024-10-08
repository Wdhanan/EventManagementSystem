package com.example.eventmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table( name ="participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    //@OneToMany (mappedBy = "participant")
    private Long eventId;  // Référence à l'événement
    private String password;


    // Getters et Setters
}
