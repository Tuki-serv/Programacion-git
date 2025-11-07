package com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import java.util.List;

public record CursoRespuestaDTO(
        Long id,
        String nombre,
        Long profesorId,
        List<EstudianteRespuestaDTO> estudiantes
) {}
