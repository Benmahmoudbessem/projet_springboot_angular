package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.Note;
import org.example.hassoun_school.Entity.Parent;
import org.example.hassoun_school.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public Note createNote(Note note) {return noteRepository.save(note);}
    public List<Note> getAllNote() { return noteRepository.findAll();}
    public Note getNoteByID(long id){return noteRepository.findById(id).orElse(null);}
    public Note UpdateNote(Note note){return noteRepository.saveAndFlush(note);}
    public void deleteNote(long id){ noteRepository.deleteById(id);}
}


