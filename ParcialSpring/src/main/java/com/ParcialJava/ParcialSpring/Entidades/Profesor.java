package com.ParcialJava.ParcialSpring.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Profesor extends Base{
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

}
