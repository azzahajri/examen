package edu.polytech.examentp.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.entity.Projet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

@Entity
@Table(name = "chef_de_projet")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChefDeProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "chefDeProjet", cascade = CascadeType.ALL)
   // @JsonBackReference
    private Collection<Projet> projets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "bureau_id")
    private Bureau bureau;
}
