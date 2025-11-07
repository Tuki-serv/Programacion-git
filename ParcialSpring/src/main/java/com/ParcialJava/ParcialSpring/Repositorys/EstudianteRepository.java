package com.ParcialJava.ParcialSpring.Repositorys;

import com.ParcialJava.ParcialSpring.Entidades.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository extends BaseRepository<Estudiante, Long>{
    // Lista todos los estudiantes por id de curso
    List<Estudiante> findByCursosIdOrderByIdAsc(Long cursoId);


    // Lista todos los estudiantes activos por id de curso
    List<Estudiante> findByCursosIdAndEliminadoFalseOrderByIdAsc(Long cursoId);

    // Lista todos los estudiantes eliminados por id de curso
    List<Estudiante> findByCursosIdAndEliminadoTrueOrderByIdAsc(Long cursoId);


    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
}
