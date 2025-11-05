package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;

import java.util.List;

public interface CursoService extends BaseService<Curso, CursoPostDTO, CursoRespuestaDTO> {
    void asignarEstudiante(Long cursoId, Long estudianteId);

    List<CursoRespuestaDTO> cursosPorEstudiante(Long estudianteId);
}
