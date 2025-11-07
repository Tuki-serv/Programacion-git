package com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;

import java.util.List;

public record ProfesorRespuestaDTO(
        Long id,
        String nombre,
        String email,
        List<CursoRespuestaDTO> cursos
) {}
