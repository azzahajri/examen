package edu.polytech.examentp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "myChefDeProjet")
@Getter
@Setter
public class ChefDeProjet {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "chefDeProjet", cascade = CascadeType.ALL)  // Adjusted mappedBy to "chefDeProjet"
    private Set<Projet> projets;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToOne
//    @JoinColumn(name = "bureau_id")
//    private Bureau bureau;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

}