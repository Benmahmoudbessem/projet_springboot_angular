package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.Niveau;
import org.example.hassoun_school.Entity.Parent;
import org.example.hassoun_school.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentRestController {
    @Autowired
    ParentService parentService;

    @PostMapping("/save")
    public Parent saveParent(@RequestBody Parent parent  ){
        return parentService.createParent(parent);
    }

    @GetMapping("/all")
    public List<Parent> getAllParent(){
        return parentService.getAllParent();
    }

    @GetMapping("/getone/{id}")
    public Parent getoneParent(@PathVariable int id){
        return parentService.getParentByID(id);
    }


    @PutMapping("/update/{id}")
    public Parent updateParent(@PathVariable int id , @RequestBody Parent parent) {
        Parent p1 = parentService.getParentByID(id);
        if (p1 != null) {
            parent.setId((long) id);
            return parentService.UpdateParent(parent);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteParent(@PathVariable("id") int id){
        try {
            parentService.deleteParent(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}



