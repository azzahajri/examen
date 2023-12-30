package edu.polytech.examentp.repository;

import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
