package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.MembreEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.polytech.examentp.repository.MembreEquipeRpository;
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
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MembreEquipe>> getAllMembresEquipe() {
        Iterable<MembreEquipe> membresEquipe = membreEquipeRepository.findAll();
        return new ResponseEntity<>(membresEquipe, HttpStatus.OK);
    }

    // Add other methods as needed
}
