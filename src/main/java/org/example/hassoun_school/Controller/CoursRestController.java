package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.Cours;
import org.example.hassoun_school.Entity.Parent;
import org.example.hassoun_school.Repository.CourRepository;
import org.example.hassoun_school.Service.CourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cour")
public class CoursRestController {

    @Autowired
    CourService courService;


    @PostMapping("/save")
    public Cours saveCours(@RequestBody Cours cours  ){
        return courService.createCours(cours);
    }

    @GetMapping("/all")
    public List<Cours> getAllCours(){
        return courService.getAllCours();
    }

    @GetMapping("/getone/{id}")
    public Cours getoneCours(@PathVariable int id){
        return courService.getCoursByID(id);
    }


    @PutMapping("/update/{id}")
    public Cours updateCours(@PathVariable int id , @RequestBody Cours cours) {
        Cours C1 = courService.getCoursByID(id);
        if (C1 != null) {
            cours.setId((long) id);
            return courService.UpdateCours(cours);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCours(@PathVariable("id") int id){
        try {
            courService.deleteCours(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }



}
