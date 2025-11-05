package com.ParcialJava.ParcialSpring.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Curso extends Base{
    private String nombre;

    @ManyToOne
    private Profesor profesor;

    private void vincularConProfesor(Curso curso, Profesor profesor) {
        curso.setProfesor(profesor);
    }


    @ManyToMany
    @JoinTable(
            name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private List<Estudiante> estudiantes;

}
