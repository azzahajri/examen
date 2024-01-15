package edu.polytech.examentp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.polytech.examentp.entity.ChefDeProjet;
import edu.polytech.examentp.entity.MembreEquipe;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private LocalDate dateDebut;

  //  @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "projet_id", referencedColumnName = "id")
    //@JsonIgnore  // Ignorer la sérialisation de cette propriété
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private  ChefDeProjet chefDeProjet;


    @ManyToMany
    @JoinTable(name = "projet_membre_equipe",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "membre_equipe_id"))
    private Set<MembreEquipe> membresEquipe;


}