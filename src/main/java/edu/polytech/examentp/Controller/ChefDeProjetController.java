package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.ChefDeProjet;
import edu.polytech.examentp.entity.Projet;
import edu.polytech.examentp.repository.ChefDeProjetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chef")
public class ChefDeProjetController {
    private static final Logger log = LoggerFactory.getLogger(ProjetController.class);

    @Autowired
    private ChefDeProjetRepository chefDeProjetRepository;

    // Create
    @PostMapping("/add")
    public ResponseEntity<ChefDeProjet> createChef(@RequestBody ChefDeProjet chefDeProjet) {
        try {
            ChefDeProjet createdChef = chefDeProjetRepository.save(chefDeProjet);
            return new ResponseEntity<>(createdChef, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error while processing the request", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read All
    @GetMapping("/all")
    public ResponseEntity<Iterable<ChefDeProjet>> getAllProjets() {
        try {
            Iterable<ChefDeProjet> projets = chefDeProjetRepository.findAll();
            return ResponseEntity.ok(projets);  // Use ResponseEntity.ok() for a successful response
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<ChefDeProjet> updateChef(@PathVariable Long id, @RequestBody ChefDeProjet updatedChef) {
        try {
            Optional<ChefDeProjet> chefData = chefDeProjetRepository.findById(id);
            if (chefData.isPresent()) {
                ChefDeProjet existingChef = chefData.get();
                existingChef.setNom(updatedChef.getNom());
                // Update other fields as needed

                ChefDeProjet updatedChefObj = chefDeProjetRepository.save(existingChef);
                return new ResponseEntity<>(updatedChefObj, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteChef(@PathVariable Long id) {
        try {
            chefDeProjetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAllchefs")
    public ResponseEntity<HttpStatus> deleteAllChefs() {
        try {
            chefDeProjetRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
