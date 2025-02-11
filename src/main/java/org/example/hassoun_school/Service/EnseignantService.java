package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.Enseignant;
import org.example.hassoun_school.Entity.Etudiant;
import org.example.hassoun_school.Entity.Niveau;
import org.example.hassoun_school.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    EnseignantRepository enseignantRepository;

    public Enseignant createEnseingnant(Enseignant enseignant) {return enseignantRepository.save(enseignant);}
    public List<Enseignant> getAllEnseignant() { return enseignantRepository.findAll();}
    public Enseignant getEnseignantByID(long id){return enseignantRepository.findById(id).orElse(null);}
    public Enseignant UpdateEnseignant(Enseignant enseignant){return enseignantRepository.saveAndFlush(enseignant);}
    public void deleteEnseignant(long id){ enseignantRepository.deleteById(id);}
}
