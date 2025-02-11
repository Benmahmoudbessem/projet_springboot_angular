package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.Cours;
import org.example.hassoun_school.Entity.Note;
import org.example.hassoun_school.Repository.CourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourService {
    @Autowired
    CourRepository courRepository;

    public Cours createCours(Cours cours ) {return courRepository.save(cours);}
    public List<Cours> getAllCours() { return courRepository.findAll();}
    public Cours getCoursByID(long id){return courRepository.findById(id).orElse(null);}
    public Cours UpdateCours(Cours cours){return courRepository.saveAndFlush(cours);}
    public void deleteCours(long id){ courRepository.deleteById(id);}
}



