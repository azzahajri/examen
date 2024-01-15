package edu.polytech.examentp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.polytech.examentp.entity.Projet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
@Getter
@Setter
@ToString
@Entity
@Table(name = "membre_equipe")
public class MembreEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "projet_membre_equipe",
            joinColumns = @JoinColumn(name = "membre_equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "projet_id"))
    private Set<Projet> projets;

}
