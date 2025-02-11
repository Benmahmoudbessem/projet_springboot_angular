package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.Note;

import org.example.hassoun_school.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/note")
public class NoteRestController {
    @Autowired
    NoteService noteService;

    @PostMapping("/save")
    public Note saveNote(@RequestBody Note note  ){
        return noteService.createNote(note);
    }

    @GetMapping("/all")
    public List<Note> getAllNote(){
        return noteService.getAllNote();
    }

    @GetMapping("/getone/{id}")
    public Note getoneNote(@PathVariable int id){
        return noteService.getNoteByID(id);
    }



    @PutMapping("/update/{id}")
    public Note updateNote(@PathVariable int id , @RequestBody Note note) {
        Note n1 = noteService.getNoteByID(id);
        if (n1 != null) {
            note.setId((long) id);
            return noteService.UpdateNote(note);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable("id") int id){
        try {
            noteService.deleteNote(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
