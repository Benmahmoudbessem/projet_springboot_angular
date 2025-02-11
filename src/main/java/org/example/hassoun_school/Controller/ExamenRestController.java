package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.Cours;
import org.example.hassoun_school.Entity.Examen;
import org.example.hassoun_school.Service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
public class ExamenRestController {
    @Autowired
    ExamenService examenService;


    @PostMapping("/save")
    public Examen saveExamen(@RequestBody Examen examen  ){
        return examenService.createExamen(examen);
    }

    @GetMapping("/all")
    public List<Examen> getAllExamen(){
        return examenService.getAllExamen();
    }

    @GetMapping("/getone/{id}")
    public Examen getoneExamen(@PathVariable int id){
        return examenService.getExamenByID(id);
    }


    @PutMapping("/update/{id}")
    public Examen updateExamen(@PathVariable int id , @RequestBody Examen examen) {
        Examen E1  = examenService.getExamenByID(id);
        if (E1 != null) {
            examen.setId((long) id);
            return examenService.UpdateExamen(examen);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteExamen(@PathVariable("id") int id){
        try {
            examenService.deleteExamen(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }



}
