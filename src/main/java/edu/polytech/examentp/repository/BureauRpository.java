package edu.polytech.examentp.repository;

import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.entity.ChefDeProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BureauRpository extends CrudRepository<Bureau, Long> {

}

