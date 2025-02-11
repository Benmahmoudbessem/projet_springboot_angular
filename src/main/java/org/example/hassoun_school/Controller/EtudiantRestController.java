package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.Etudiant;
import org.example.hassoun_school.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("etudiant")
public class EtudiantRestController {

    @Autowired
    EtudiantService etudiantService;

    @PostMapping("/save")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant ){
        return etudiantService.createEtudiant(etudiant);
    }

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiant();
    }
    @GetMapping("/getone/{id}")
    public Etudiant getoneEtudiant(@PathVariable int id){
        return etudiantService.getEtudiantByID(id);
    }

    @PutMapping("/update/{id}")
    public Etudiant updateEtudiant(@PathVariable int id , @RequestBody Etudiant etudiant) {
        Etudiant e1 = etudiantService.getEtudiantByID(id);
        if (e1 != null) {
            etudiant.setId((long) id);
            return etudiantService.UpdateEtudiant(etudiant);
        } else {
            throw new RuntimeException("failed!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id){
        try {
            etudiantService.deleteEtudiant(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
