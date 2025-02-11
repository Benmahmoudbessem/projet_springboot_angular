package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Repository.ClasseERepository;
import org.example.hassoun_school.Repository.EnseignantRepository;
import org.example.hassoun_school.Repository.EtudiantRepositroy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardRestController {

    private final EtudiantRepositroy etudiantRepository;
    private final EnseignantRepository enseignantRepository;
    private final ClasseERepository classeRepository;

    public DashboardRestController(EtudiantRepositroy etudiantRepository, EnseignantRepository enseignantRepository, ClasseERepository classeRepository) {
        this.etudiantRepository = etudiantRepository;
        this.enseignantRepository = enseignantRepository;
        this.classeRepository = classeRepository;
    }

    @GetMapping
    public Map<String, Long> getDashboardStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("etudiants", etudiantRepository.count());
        stats.put("enseignants", enseignantRepository.count());
        stats.put("classes", classeRepository.count());
        return stats;
    }
}

