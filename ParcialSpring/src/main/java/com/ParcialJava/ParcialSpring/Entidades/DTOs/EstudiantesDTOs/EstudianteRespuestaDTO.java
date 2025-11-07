package com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs;


import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import java.util.List;

public record EstudianteRespuestaDTO(
        Long id,
        String nombre,
        String matricula,
        List<CursoRespuestaDTO> cursos
) {}
