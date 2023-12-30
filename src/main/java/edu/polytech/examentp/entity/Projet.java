package edu.polytech.examentp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "myprojet")
@Getter
@Setter
public class Projet {

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToMany(mappedBy = "projets")
//    private Set<MembreEquipe> membresEquipe;

//    @JsonIgnoreProperties("projets")
//    @JoinTable(
//            name = "Membre-Equipe",
//            joinColumns = @JoinColumn(name = "Membre-Equipe-id"),
//            inverseJoinColumns = @JoinColumn(name = "Membre-Equipe-nom")
//    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "chef_id")
    private ChefDeProjet chefDeProjet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Use appropriate strategy for your database
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String email;

}