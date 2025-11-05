package com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;

import java.util.List;

public record CursoRespuestaDTO (Long id, String nombre, ProfesorRespuestaDTO profesor, List<EstudianteRespuestaDTO> estudiantes) {
}
