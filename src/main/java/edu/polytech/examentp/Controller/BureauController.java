package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.Bureau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.polytech.examentp.repository.BureauRpository;
@RestController
@RequestMapping("/bureaux")
public class BureauController {

    @Autowired
    private BureauRpository bureauRepository;

    @PostMapping("/add")
    public ResponseEntity<Bureau> addBureau(@RequestBody Bureau bureau) {
        try {
            Bureau savedBureau = bureauRepository.save(bureau);
            return new ResponseEntity<>(savedBureau, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Bureau>> getAllBureaux() {
        Iterable<Bureau> bureaux = bureauRepository.findAll();
        return new ResponseEntity<>(bureaux, HttpStatus.OK);
    }

    // Add other methods as needed
}