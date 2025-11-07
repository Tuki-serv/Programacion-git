package com.ParcialJava.ParcialSpring.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Curso extends Base{
    private String nombre;

    @ManyToOne
    private Profesor profesor;

    public void vincularConProfesor(Profesor profesor) {
        this.profesor = profesor;
        profesor.vincularConCurso(this); // solo si querés que se auto-sincronice
    }



    @ManyToMany
    @JoinTable(
            name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private List<Estudiante> estudiantes = new ArrayList<>();

    public void vincularConEstudiante(Estudiante estudiante){
        if (!this.estudiantes.contains(estudiante)) {
            this.estudiantes.add(estudiante);
            estudiante.vincularConCurso(this);
        }

    }

}
