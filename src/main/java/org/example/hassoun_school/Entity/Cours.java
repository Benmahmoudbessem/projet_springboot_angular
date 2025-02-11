package org.example.hassoun_school.Entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private Long durée;

    public Long getId() {
        return id;
    }

    public ClasseE getClasseE() {
        return classeE;
    }

    public void setClasseE(ClasseE classeE) {
        this.classeE = classeE;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    private ClasseE classeE;
    @ManyToOne
    private Enseignant enseignant;
}
