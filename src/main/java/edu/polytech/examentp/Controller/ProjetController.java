package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.ChefDeProjet;
import edu.polytech.examentp.entity.Projet;
import edu.polytech.examentp.repository.ChefDeProjetRepository;
import edu.polytech.examentp.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;

    @PostMapping("/add")
    public ResponseEntity<Projet> addProjet(@RequestBody Projet projet) {
        try {
            Projet projetObj = projetRepository.save(projet);
            return new ResponseEntity<>(projetObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProjets() {
        try {
            Iterable<Projet> projets = projetRepository.findAll();
            return ResponseEntity.ok(projets);  // Use ResponseEntity.ok() for a successful response
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve projects", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateProjet/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet updatedProjet) {
        try {
            Optional<Projet> projetData = projetRepository.findById(id);
            if (projetData.isPresent()) {
                Projet existingProjet = projetData.get();

                // Update fields
                existingProjet.setNom(updatedProjet.getNom());
                //existingProjet.setEmail(updatedProjet.getEmail());

                // Update relationships
                existingProjet.setChefDeProjet(updatedProjet.getChefDeProjet());

                Projet updatedProjetObj = projetRepository.save(existingProjet);
                return new ResponseEntity<>(updatedProjetObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllProjets")
    public ResponseEntity<HttpStatus> deleteAllProjets() {
        try {
            projetRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteProjetById/{id}")
    public ResponseEntity<HttpStatus> deleteProjet(@PathVariable Long id) {
        try {
            projetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            // The record with the given id doesn't exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

