package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.ClasseE;
import org.example.hassoun_school.Entity.Enseignant;
import org.example.hassoun_school.Service.ClasseEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseERestController {

    @Autowired
    ClasseEService classeEService;

    @PostMapping("/save")
    public ClasseE saveClasseE(@RequestBody ClasseE classeE ){
        return classeEService.createClasseE(classeE);
    }

    @GetMapping("/all")
    public List<ClasseE> getAllClasseE(){
        return classeEService.getAllClasseE();
    }
    @GetMapping("/getone/{id}")
    public ClasseE getoneClasseE(@PathVariable int id){
        return classeEService.getClasseEByID(id);
    }



    @PutMapping("/update/{id}")
    public ClasseE updateClasseE(@PathVariable int id , @RequestBody ClasseE classeE) {
        ClasseE c1 = classeEService.getClasseEByID(id);
        if (c1 != null) {
            classeE.setId((long) id);
            return classeEService.UpdateClasseE(classeE);
        } else {
            throw new RuntimeException("failed!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteClasseE(@PathVariable("id") int id){
        try {
            classeEService.deleteClasseE(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
