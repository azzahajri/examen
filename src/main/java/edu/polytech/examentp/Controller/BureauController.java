package edu.polytech.examentp.Controller;

import edu.polytech.examentp.entity.Bureau;
import edu.polytech.examentp.repository.BureauRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bureaux")
public class BureauController {

    @Autowired
    private BureauRpository bureauRepository;

    // Create
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
    public ResponseEntity<List<Bureau>> getAllBureaux() {
        try {
            List<Bureau> bureaux = (List<Bureau>) bureauRepository.findAll();
            return new ResponseEntity<>(bureaux, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Bureau> updateBureau(@PathVariable Long id, @RequestBody Bureau updatedBureau) {
        try {
            Optional<Bureau> bureauData = bureauRepository.findById(id);
            if (bureauData.isPresent()) {
                Bureau existingBureau = bureauData.get();
                existingBureau.setLocalisation(updatedBureau.getLocalisation());
                // Update other fields as needed

                Bureau updatedBureauObj = bureauRepository.save(existingBureau);
                return new ResponseEntity<>(updatedBureauObj, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBureau(@PathVariable Long id) {
        try {
            bureauRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAllbureaux")
    public ResponseEntity<HttpStatus> deleteAllbureaux() {
        try {
            bureauRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
