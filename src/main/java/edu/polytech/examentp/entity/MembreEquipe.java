package edu.polytech.examentp.entity;

import edu.polytech.examentp.entity.Projet;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "membre_equipe")
public class MembreEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany
    @JoinTable(
            name = "projet_membre_equipe",
            joinColumns = @JoinColumn(name = "membre_equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "projet_id"))
    private Set<Projet> projets;

    // getters and setters
}
