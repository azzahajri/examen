package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.MembreEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.polytech.examentp.repository.MembreEquipeRpository;

import java.util.Optional;

@RestController
@RequestMapping("/membresEquipe")
public class MembreEquipeController {

    @Autowired
    private MembreEquipeRpository membreEquipeRepository;

    @PostMapping("/add")
    public ResponseEntity<MembreEquipe> addMembreEquipe(@RequestBody MembreEquipe membreEquipe) {
        try {
            MembreEquipe savedMembreEquipe = membreEquipeRepository.save(membreEquipe);
            return new ResponseEntity<>(savedMembreEquipe, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception for detailed analysis
            e.printStackTrace();  // This is just a simple example, consider using a logging framework
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MembreEquipe>> getAllMembresEquipe() {
        try {
            Iterable<MembreEquipe> membresEquipe = membreEquipeRepository.findAll();
            return new ResponseEntity<>(membresEquipe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MembreEquipe> updateMembreEquipe(@PathVariable Long id, @RequestBody MembreEquipe updatedMembreEquipe) {
        try {
            Optional<MembreEquipe> membreEquipeData = membreEquipeRepository.findById(id);
            if (membreEquipeData.isPresent()) {
                MembreEquipe existingMembreEquipe = membreEquipeData.get();
                existingMembreEquipe.setNom(updatedMembreEquipe.getNom());
                // Update other fields as needed

                MembreEquipe updatedMembreEquipeObj = membreEquipeRepository.save(existingMembreEquipe);
                return new ResponseEntity<>(updatedMembreEquipeObj, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteMembreEquipe(@PathVariable Long id) {
        try {
            membreEquipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAllMembreEquipe")
    public ResponseEntity<HttpStatus> deleteAllMembreEquipe() {
        try {
            membreEquipeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}