package org.example.hassoun_school.Repository;

import org.example.hassoun_school.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
