package org.example.hassoun_school.Service;

import org.example.hassoun_school.Entity.Cours;
import org.example.hassoun_school.Entity.Examen;
import org.example.hassoun_school.Repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenService {
    @Autowired
    ExamenRepository examenRepository;

    public Examen createExamen(Examen examen ) {return examenRepository.save(examen);}
    public List<Examen> getAllExamen() { return examenRepository.findAll();}
    public Examen getExamenByID(long id){return examenRepository.findById(id).orElse(null);}
    public Examen UpdateExamen(Examen examen){return examenRepository.saveAndFlush(examen);}
    public void deleteExamen(long id){ examenRepository.deleteById(id);}
}


