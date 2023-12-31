package edu.polytech.examentp.entity;

import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.entity.Projet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "chef_de_projet")
public class ChefDeProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projet_id", referencedColumnName = "id")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "bureau_id")
    private Bureau bureau;

    // getters and setters
}
