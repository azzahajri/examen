package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.ChefDeProjet;
import edu.polytech.examentp.entity.Projet;
import edu.polytech.examentp.repository.ChefDeProjetRepository;
import edu.polytech.examentp.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("/chefsDeProjet")
public class ChefDeProjetController {

    @Autowired
    private ChefDeProjetRepository chefDeProjetRepository;

    @PostMapping("/add")
    public ResponseEntity<ChefDeProjet> addChefDeProjet(@RequestBody ChefDeProjet chefDeProjet) {
        try {
            ChefDeProjet savedChefDeProjet = chefDeProjetRepository.save(chefDeProjet);
            return new ResponseEntity<>(savedChefDeProjet, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ChefDeProjet>> getAllChefsDeProjet() {
        Iterable<ChefDeProjet> chefsDeProjet = chefDeProjetRepository.findAll();
        return new ResponseEntity<>(chefsDeProjet, HttpStatus.OK);
    }

    // Add other methods as needed
}

//    @PutMapping("/updateChef/{id}")
//    public ResponseEntity<ChefDeProjet> updateChef(@PathVariable Long id, @RequestBody ChefDeProjet updatedChef) {
//        try {
//            Optional<ChefDeProjet> chefData = chefDeProjetRepository.findById(id);
//            if (chefData.isPresent()) {
//                ChefDeProjet existingChef = chefData.get();
//
//                // Update fields (assuming ChefDeProjet has an 'id' field)
//                existingChef.setNom(updatedChef.getNom());
//
//                // Update relationships (assuming ChefDeProjet has a 'projet' field)
//                existingChef.setProjet(updatedChef.getProjet());
//
//                // Save the updated chef object
//                ChefDeProjet updatedChefObj = chefDeProjetRepository.save(existingChef);
//
//                return new ResponseEntity<>(updatedChefObj, HttpStatus.OK);
//            }
//
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            // Handle exceptions appropriately, log or rethrow as needed
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @DeleteMapping("/deleteAllChef")
//    public ResponseEntity<HttpStatus> deleteAllChefs() {
//        try {
//            chefDeProjetRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//]
