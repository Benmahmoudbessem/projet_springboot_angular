package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.ClasseE;
import org.example.hassoun_school.Entity.Parent;
import org.example.hassoun_school.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    ParentRepository parentRepository;

    public Parent createParent(Parent parent) {return parentRepository.save(parent);}
    public List<Parent> getAllParent() { return parentRepository.findAll();}
    public Parent getParentByID(long id){return parentRepository.findById(id).orElse(null);}
    public Parent UpdateParent(Parent parent){return parentRepository.saveAndFlush(parent);}
    public void deleteParent(long id){ parentRepository.deleteById(id);}
}


