package com.ParcialJava.ParcialSpring.Repositorys;

import com.ParcialJava.ParcialSpring.Entidades.Estudiante;

public interface EstudianteRepository extends BaseRepository<Estudiante, Long>{
    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
}
