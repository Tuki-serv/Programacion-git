package com.ParcialJava.ParcialSpring.Service.InterfacesServicios;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CursoService extends BaseService<Curso, CursoPostDTO , CursoUpdateDTO, CursoRespuestaDTO> {
    List<CursoRespuestaDTO> listarTodos();
    ResponseEntity<?> registrar(CursoPostDTO dto);
    ResponseEntity<?> editar(Long id, CursoUpdateDTO dto);
}
