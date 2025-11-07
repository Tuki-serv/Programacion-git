package com.ParcialJava.ParcialSpring.Repositorys;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface CursoRepository extends BaseRepository<Curso, Long> {
    // Lista todos los cursos por id de estudiante
    List<Curso> findByEstudiantesIdOrderByIdAsc(Long estudianteId);

    // Lista todos los cursos activos por id de estudiante
    List<Curso> findByEstudiantesIdAndEliminadoFalseOrderByIdAsc(Long estudianteId);

    // Lista todos los cursos eliminados por id de estudiante
    List<Curso> findByEstudiantesIdAndEliminadoTrueOrderByIdAsc(Long estudianteId);

    // Lista todos los cursos por id de profesor
    List<Curso> findByProfesorIdOrderByIdAsc(Long profesorId);

    // Lista todos los cursos activos por id de profesor
    List<Curso> findByProfesorIdAndEliminadoFalseOrderByIdAsc(Long profesorId);

    // Lista todos los cursos eliminados por id de profesor
    List<Curso> findByProfesorIdAndEliminadoTrueOrderByIdAsc(Long profesorId);




    List<Curso> findByEstudiantes_Id(Long estudianteId);
    Boolean existsByNombreAndProfesorId(String nombre, Long profesorId);
}
