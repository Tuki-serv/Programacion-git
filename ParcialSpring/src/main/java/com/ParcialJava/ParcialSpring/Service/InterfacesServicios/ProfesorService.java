package com.ParcialJava.ParcialSpring.Service.InterfacesServicios;


import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorUpdateDTO;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfesorService extends BaseService<Profesor, ProfesorPostDTO, ProfesorUpdateDTO, ProfesorRespuestaDTO> {
    ResponseEntity<?> registrar(ProfesorPostDTO dto);
    ResponseEntity<?> editar(Long id, ProfesorUpdateDTO dto);
    void eliminar(Long id);
    ResponseEntity<?> reactivar(Long id);

    List<ProfesorRespuestaDTO> listarTodos();
    List<ProfesorRespuestaDTO> listarActivos();
    List<ProfesorRespuestaDTO> listarEliminados();

    ResponseEntity<?> listarTodoLosCursos(Long id);
    ResponseEntity<?> listarTodoLosCursosActivos(Long id);
    ResponseEntity<?> listarTodoLosCursosEliminados(Long id);

}
