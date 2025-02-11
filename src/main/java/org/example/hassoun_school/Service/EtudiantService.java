package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.Etudiant;
import org.example.hassoun_school.Repository.EtudiantRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    EtudiantRepositroy etudiantRepositroy;


    public Etudiant createEtudiant(Etudiant etudiant) {return etudiantRepositroy.save(etudiant);}
    public List<Etudiant> getAllEtudiant() { return etudiantRepositroy.findAll();}
    public Etudiant getEtudiantByID(long id){return etudiantRepositroy.findById(id).orElse(null);}
    public Etudiant UpdateEtudiant(Etudiant etudiant){return etudiantRepositroy.saveAndFlush(etudiant);}
    public void deleteEtudiant(long id){ etudiantRepositroy.deleteById(id);}
}
