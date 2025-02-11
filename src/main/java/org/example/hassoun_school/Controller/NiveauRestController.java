package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.Etudiant;
import org.example.hassoun_school.Entity.Niveau;
import org.example.hassoun_school.Service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveau")
@CrossOrigin(origins = "http://localhost:4200")
public class NiveauRestController {


    @Autowired
    NiveauService niveauService;

    @PostMapping("/save")
    public Niveau saveNiveau(@RequestBody Niveau niveau  ){
        return niveauService.createNiveau(niveau);
    }

    @GetMapping("/all")
    public List<Niveau> getAllNiveau(){
        return niveauService.getAllNiveau();
    }

    @GetMapping("/getone/{id}")
    public Niveau getoneNiveau(@PathVariable int id){
        return niveauService.getNiveauByID(id);
    }

    @PutMapping("/update/{id}")
    public Niveau updateNiveau(@PathVariable int id , @RequestBody Niveau niveau) {
        Niveau n1 = niveauService.getNiveauByID(id);
        if (n1 != null) {
            niveau.setId((long) id);
            return niveauService.UpdateNiveau(niveau);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteNiveau(@PathVariable("id") int id){
        try {
            niveauService.deleteNiveau(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
