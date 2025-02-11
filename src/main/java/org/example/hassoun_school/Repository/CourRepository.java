package org.example.hassoun_school.Repository;

import org.example.hassoun_school.Entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourRepository extends JpaRepository<Cours,Long> {
}
