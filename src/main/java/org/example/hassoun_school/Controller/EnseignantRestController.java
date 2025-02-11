package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.Enseignant;
import org.example.hassoun_school.Entity.Etudiant;
import org.example.hassoun_school.Service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enseignant")
public class EnseignantRestController {

    @Autowired
    EnseignantService enseignantService;


    @PostMapping("/save")
    public Enseignant saveEnseignant(@RequestBody Enseignant enseignant ){
        return enseignantService.createEnseingnant(enseignant);
    }

    @GetMapping("/all")
    public List<Enseignant> getAllEnseignant(){
        return enseignantService.getAllEnseignant();
    }
    @GetMapping("/getone/{id}")
    public Enseignant getoneEnseignant(@PathVariable int id){
        return enseignantService.getEnseignantByID(id);
    }


    @PutMapping("/update/{id}")
    public Enseignant updateEnseignant(@PathVariable int id , @RequestBody Enseignant enseignant) {
        Enseignant en1 = enseignantService.getEnseignantByID(id);
        if (en1 != null) {
            enseignant.setId((long) id);
            return enseignantService.UpdateEnseignant(enseignant);
        } else {
            throw new RuntimeException("failed!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEnseingnant(@PathVariable("id") int id){
        try {
            enseignantService.deleteEnseignant(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
