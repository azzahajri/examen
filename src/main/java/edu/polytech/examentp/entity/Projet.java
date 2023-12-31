package edu.polytech.examentp.entity;

import edu.polytech.examentp.entity.ChefDeProjet;
import edu.polytech.examentp.entity.MembreEquipe;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "projet")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @OneToOne(mappedBy = "projet", cascade = CascadeType.ALL)
    private ChefDeProjet chefDeProjet;

    @ManyToMany (mappedBy = "projets")
    private Set<MembreEquipe> membresEquipe;

    // getters and setters
}
