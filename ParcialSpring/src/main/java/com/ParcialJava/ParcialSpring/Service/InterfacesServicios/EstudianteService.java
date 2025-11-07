package com.ParcialJava.ParcialSpring.Service.InterfacesServicios;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudiantePostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteUpdateDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstudianteService extends BaseService<Estudiante, EstudiantePostDTO, EstudianteUpdateDTO, EstudianteRespuestaDTO> {

    ResponseEntity<?> registrar(EstudiantePostDTO dto);
    ResponseEntity<?> editar(Long id, EstudianteUpdateDTO dto);
    void eliminar(Long id);
    ResponseEntity<?> reactivar(Long id);

    List<EstudianteRespuestaDTO> listarTodos();
    List<EstudianteRespuestaDTO> listarActivos();
    List<EstudianteRespuestaDTO> listarEliminados();

    ResponseEntity<?> listarTodosLosCursos(Long id);
    ResponseEntity<?> listarCursosActivos(Long id);
    ResponseEntity<?> listarCursosEliminados(Long id);

}
