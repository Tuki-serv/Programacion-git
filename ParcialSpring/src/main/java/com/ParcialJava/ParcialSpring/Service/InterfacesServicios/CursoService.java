package com.ParcialJava.ParcialSpring.Service.InterfacesServicios;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CursoService extends BaseService<Curso, CursoPostDTO , CursoUpdateDTO, CursoRespuestaDTO> {
    CursoRespuestaDTO crear(CursoPostDTO dto);
    CursoRespuestaDTO actualizar(Long id, CursoUpdateDTO dto);
    void eliminar(Long id);
    ResponseEntity<?> reactivar(Long id);
    ResponseEntity<?> registrar(CursoPostDTO dto);
    ResponseEntity<?> editar(Long id, CursoUpdateDTO dto);


    List<CursoRespuestaDTO> listarTodos();
    List<CursoRespuestaDTO> listarActivos();
    List<CursoRespuestaDTO> listarEliminados();

    ResponseEntity<?> listarTodosLosEstudiantes(Long id);
    ResponseEntity<?> listarEstudiantesActivos(Long id);
    ResponseEntity<?> listarEstudiantesEliminados(Long id);

    ResponseEntity<?> asignarEstudiante(Long cursoId, Long estudianteId);

}
