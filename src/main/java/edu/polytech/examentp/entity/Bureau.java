package edu.polytech.examentp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mybureau")
@Getter
@Setter
public class Bureau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

//    @OneToMany
//    @JoinColumn(name = "bureau-id")
//    private ChefDeProjet chefDeProjet;



}
