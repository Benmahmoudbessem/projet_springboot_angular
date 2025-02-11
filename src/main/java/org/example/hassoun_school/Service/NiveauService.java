package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.Etudiant;
import org.example.hassoun_school.Entity.Niveau;
import org.example.hassoun_school.Repository.EtudiantRepositroy;
import org.example.hassoun_school.Repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService {
    @Autowired
    NiveauRepository niveauRepository ;

    public Niveau createNiveau(Niveau niveau) {return niveauRepository.save(niveau);}
    public List<Niveau> getAllNiveau() { return niveauRepository.findAll();}
    public Niveau getNiveauByID(long id){return niveauRepository.findById(id).orElse(null);}
    public Niveau UpdateNiveau(Niveau niveau){return niveauRepository.saveAndFlush(niveau);}
    public void deleteNiveau(long id){ niveauRepository.deleteById(id);}
}

