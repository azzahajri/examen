package edu.polytech.examentp.repository;

import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.entity.ChefDeProjet;
import edu.polytech.examentp.entity.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ChefDeProjetRepository extends CrudRepository<ChefDeProjet, Long> {

}