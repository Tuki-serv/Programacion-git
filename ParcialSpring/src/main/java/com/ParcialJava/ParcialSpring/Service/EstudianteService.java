package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudiantePostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstudianteService extends BaseService<Estudiante, EstudiantePostDTO, EstudianteRespuestaDTO> {
    ResponseEntity<?> registrar(EstudiantePostDTO dto);
    List<CursoRespuestaDTO> cursosPorEstudiante(Long estudianteId);
}
