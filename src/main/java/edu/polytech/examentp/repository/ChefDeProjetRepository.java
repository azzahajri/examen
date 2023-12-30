package edu.polytech.examentp.repository;

import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.entity.ChefDeProjet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefDeProjetRepository extends JpaRepository<ChefDeProjet, Long> {
}