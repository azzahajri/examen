package edu.polytech.examentp.repository;

import edu.polytech.examentp.entity.MembreEquipe;
import edu.polytech.examentp.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MembreEquipeRpository extends CrudRepository<MembreEquipe, Long> {

}