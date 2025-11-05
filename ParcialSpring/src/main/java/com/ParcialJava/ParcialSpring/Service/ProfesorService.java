package com.ParcialJava.ParcialSpring.Service;


import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfesorService extends BaseService<Profesor, ProfesorPostDTO, ProfesorRespuestaDTO> {
    ResponseEntity<?> registrar(ProfesorPostDTO dto);
    List<CursoRespuestaDTO> cursosPorProfesor(Long profesorId);
}
