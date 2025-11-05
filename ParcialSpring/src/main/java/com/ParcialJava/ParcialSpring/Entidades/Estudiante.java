package com.ParcialJava.ParcialSpring.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Estudiante  extends Base{
    private String nombre;
    private String matricula;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Curso> cursos;
}
