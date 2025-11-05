package com.ParcialJava.ParcialSpring.Repositorys;

import com.ParcialJava.ParcialSpring.Entidades.Profesor;

public interface ProfesorRepository extends BaseRepository<Profesor, Long>{
    boolean existsByEmail(String email);
}
