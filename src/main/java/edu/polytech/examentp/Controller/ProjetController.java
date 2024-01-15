package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.Bureau;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/projets")
public class ProjetController {
    private static final Logger log = LoggerFactory.getLogger(ProjetController.class);

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ChefDeProjetRepository chefDeProjetRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addProjet(@RequestBody Projet projet) {
        try {
            // Manually save ChefDeProjet only if it's not null
            if (projet.getChefDeProjet() != null) {
                ChefDeProjet chefDeProjet = chefDeProjetRepository.save(projet.getChefDeProjet());
                projet.setChefDeProjet(chefDeProjet);
            }

            Projet projetObj = projetRepository.save(projet);
            return new ResponseEntity<>(projetObj, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error while processing the request", e);
            return new ResponseEntity<>("Error processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<Iterable<Projet>> getAllProjets() {
        try {
            Iterable<Projet> projets = projetRepository.findAll();
            log.info("Liste des projets récupérée avec succès.");
            return ResponseEntity.ok(projets);
        } catch (Exception e) {
            log.error("Erreur lors de la récupération de la liste des projets.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
                existingProjet.setDateDebut(updatedProjet.getDateDebut());

                // Update ChefDeProjet if provided
                if (updatedProjet.getChefDeProjet() != null) {
                    ChefDeProjet updatedChef = chefDeProjetRepository.save(updatedProjet.getChefDeProjet());
                    existingProjet.setChefDeProjet(updatedChef);
                }

                // Update MembresEquipe if provided
                if (updatedProjet.getMembresEquipe() != null) {
                    existingProjet.setMembresEquipe(updatedProjet.getMembresEquipe());
                }

                Projet updatedProjetObj = projetRepository.save(existingProjet);
                return new ResponseEntity<>(updatedProjetObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllProjets")
    public ResponseEntity<HttpStatus> deleteAllProjets() {
        try {
            projetRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
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
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}