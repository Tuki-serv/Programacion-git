package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorUpdateDTO;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import com.ParcialJava.ParcialSpring.Repositorys.ProfesorRepository;
import com.ParcialJava.ParcialSpring.Service.InterfacesServicios.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ProfesorServiceIMP extends BaseServiceIMP<Profesor, ProfesorPostDTO, ProfesorUpdateDTO, ProfesorRespuestaDTO> implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    CursoServiceIMP cursoServiceIMP;


    // Recuperar todos los cursos de un profesor
    private List<CursoRespuestaDTO> listaDeCursos(Long id){
        return cursoServiceIMP.cursosListarProfesor(id);
    }


    // Recuperar todos los cursos activos de un profesor
    public List<CursoRespuestaDTO> listaDeCursosActivos(Long id){
        return cursoServiceIMP.cursosListarProfesorActivos(id);
    }

    // Recuperar todos los cursos eliminados de un profesor
    public List<CursoRespuestaDTO> listaDeCursosEliminados(Long id){
        return cursoServiceIMP.cursosListarProfesorEliminado(id);
    }



    // Lista todos los Profesores con todos sus cursos, independientemente de su estado (activo/elminado)
//    @Override
//    public List<ProfesorRespuestaDTO> listarTodos() {
//        List<Profesor> profesores = profesorRepository.findAllByOrderByIdAsc();
//        return construirListaDeRespuestasDTO(profesores, this::listaDeCursos);
//    }
    @Override
    public List<ProfesorRespuestaDTO> listarTodos() {
        List<Profesor> profesores = profesorRepository.findAllByOrderByIdAsc();
        return construirListaDeRespuestasDTO(profesores, this::listaDeCursos);
    }


    // Lista todos los Profesores activos con todos sus cursos, independientemente de su estado (activo/elminado)
    public List<ProfesorRespuestaDTO> listarActivos() {
        List<Profesor> profesores = profesorRepository.findByEliminadoFalseOrderByIdAsc();
        return construirListaDeRespuestasDTO(profesores, this::listaDeCursos);
    }

    // Lista todos los Profesores eliminados con todos sus cursos, cada vez que se elminan un profesor, todos sus cursos se elminan
    public List<ProfesorRespuestaDTO> listarEliminados() {
        List<Profesor> profesores = profesorRepository.findByEliminadoTrueOrderByIdAsc();
        return construirListaDeRespuestasDTO(profesores, this::listaDeCursos);
    }

    // Lista todos cursos de un profesor en especifico
    public ResponseEntity<?> listarTodoLosCursos(Long id){
        Profesor profesor = buscarPorId(id);
        List<CursoRespuestaDTO> cursos = listaDeCursos(id);
        return ResponseEntity.ok(construirRespuestaDTO(profesor,cursos));
    }

    // Lista todos cursos activos de un profesor en especifico
    public ResponseEntity<?> listarTodoLosCursosActivos(Long id){
        Profesor profesor = buscarPorId(id);
        List<CursoRespuestaDTO> cursos = listaDeCursosActivos(id);
        return ResponseEntity.ok(construirRespuestaDTO(profesor,cursos));
    }

    // Lista todos cursos eliminados de un profesor en especifico
    public ResponseEntity<?> listarTodoLosCursosEliminados(Long id){
        Profesor profesor = buscarPorId(id);
        List<CursoRespuestaDTO> cursos = listaDeCursosEliminados(id);
        return ResponseEntity.ok(construirRespuestaDTO(profesor,cursos));
    }


    public ResponseEntity<?> registrar (ProfesorPostDTO dto){
        ProfesorRespuestaDTO creado = registrarConValidacion(profesorRepository.findByNombre(dto.nombre()).isPresent(), "Nombre de Profesor ya registrado", dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }


    public ResponseEntity<?> editar(Long id, ProfesorUpdateDTO dto){
        Profesor profesor = buscarPorId(id);

        if (profesor.getEliminado()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El profesor esta eliminado");
        }

        Optional<Profesor> existente = profesorRepository.findByNombre(dto.nombre());
        if (existente.isPresent() && !existente.get().getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El nombre del Profesor ya está en uso");
        }

        ProfesorRespuestaDTO actualizado = super.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

}
