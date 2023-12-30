package edu.polytech.examentp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
@Entity
@Table(name = "membre_equipe")  // Add the @Table annotation with the appropriate table name
public class MembreEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "name")

    private String nom;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToMany(mappedBy = "membresEquipe")
//    private List<Projet> projets;

    // Constructors, getters, and setters
}
