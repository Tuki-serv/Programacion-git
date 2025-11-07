package com.ParcialJava.ParcialSpring.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profesor extends Base{
    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;


    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos = new ArrayList<>();

    public void vincularConCurso(Curso curso) {
        if (!this.cursos.contains(curso)) {
            this.cursos.add(curso);
            curso.setProfesor(this); // sincroniza el lado inverso
        }
    }
}
