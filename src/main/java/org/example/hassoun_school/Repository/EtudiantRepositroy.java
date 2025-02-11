package org.example.hassoun_school.Repository;

import org.example.hassoun_school.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepositroy extends JpaRepository<Etudiant , Long> {
}
