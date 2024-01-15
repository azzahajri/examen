package edu.polytech.examentp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
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

    private String localisation;

    @OneToMany(mappedBy = "bureau", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<ChefDeProjet> chefsDeProjet;



}
