package edu.polytech.examentp.repository;

import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProjetRepository extends CrudRepository<Projet, Long> {
//    @Query("from Projet u where u.id_p=:categoryId_p")
//    public List<Projet> findAllByLastName(Integer categoryId_p);
//
//    @Query("from Projet u where u.id_p =:id_p")
//    Projet findById(int id_p);
}
