package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.ClasseE;
import org.example.hassoun_school.Entity.Enseignant;
import org.example.hassoun_school.Repository.ClasseERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseEService {
    @Autowired
    ClasseERepository classeERepository;


    public ClasseE createClasseE(ClasseE classeE) {return classeERepository.save(classeE);}
    public List<ClasseE> getAllClasseE() { return classeERepository.findAll();}
    public ClasseE getClasseEByID(long id){return classeERepository.findById(id).orElse(null);}
    public ClasseE UpdateClasseE(ClasseE classeE){return classeERepository.saveAndFlush(classeE);}
    public void deleteClasseE(long id){ classeERepository.deleteById(id);}
}


