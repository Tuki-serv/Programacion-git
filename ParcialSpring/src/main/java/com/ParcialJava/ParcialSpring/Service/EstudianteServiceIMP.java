package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudiantePostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteUpdateDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import com.ParcialJava.ParcialSpring.Repositorys.EstudianteRepository;
import com.ParcialJava.ParcialSpring.Service.InterfacesServicios.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceIMP extends BaseServiceIMP<Estudiante, EstudiantePostDTO, EstudianteUpdateDTO, EstudianteRespuestaDTO> implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    CursoServiceIMP cursoServiceIMP;

/*---------------------------------------------------------------------------------------------------------------------*/
    // Este metodo sera utilizado por CursoServiceIMP
    public List<EstudianteRespuestaDTO> estudiantesPorCurso(Long cursoId) {
        return mapear(estudianteRepository.findByCursosIdOrderByIdAsc(cursoId));
    }

    // Este metodo sera utilizado por CursoServiceIMP
    public List<EstudianteRespuestaDTO> estudiantesActivosPorCurso(Long cursoId) {
        return mapear(estudianteRepository.findByCursosIdAndEliminadoFalseOrderByIdAsc(cursoId));
    }

    // Este metodo sera utilizado por CursoServiceIMP
    public List<EstudianteRespuestaDTO> estudiantesEliminadosPorCurso(Long cursoId) {
        return mapear(estudianteRepository.findByCursosIdAndEliminadoTrueOrderByIdAsc(cursoId));
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    // Recuperar todos los cursos de un Estudiante
    private List<CursoRespuestaDTO> listaDeCursos(Long idEstudiante) {
        return cursoServiceIMP.cursosListarPorEstudiante(idEstudiante);
    }

    // Recuperar todos los cursos activos de un Estudiante
    public List<CursoRespuestaDTO> listaDeCursosActivos(Long idEstudiante) {
        return cursoServiceIMP.cursosActivosListarPorEstudiante(idEstudiante);
    }

    // Recuperar todos los cursos activos de un Estudiante
    public List<CursoRespuestaDTO> listaDeCursosEliminados(Long idEstudiante) {
        return cursoServiceIMP.cursosEliminadosListarPorEstudiante(idEstudiante);
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    // Lista todos los Estudiante con todos sus cursos, independientemente de su estado (activo/elminado)
    @Override
    public List<EstudianteRespuestaDTO> listarTodos() {
        List<Estudiante> estudiantes = estudianteRepository.findAllByOrderByIdAsc();
        return construirListaDeRespuestasDTO(estudiantes, this::listaDeCursos);
    }

    // Lista todos los Estudiante activos con todos sus cursos, independientemente de su estado (activo/elminado)
    public List<EstudianteRespuestaDTO> listarActivos() {
        List<Estudiante> estudiantes = estudianteRepository.findByEliminadoFalseOrderByIdAsc();
        return construirListaDeRespuestasDTO(estudiantes, this::listaDeCursos);
    }

    // Lista todos los Estudiante eliminados con todos sus cursos, independientemente de su estado (activo/elminado)
    public List<EstudianteRespuestaDTO> listarEliminados() {
        List<Estudiante> estudiantes = estudianteRepository.findByEliminadoTrueOrderByIdAsc();
        return construirListaDeRespuestasDTO(estudiantes, this::listaDeCursos);
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    // Lista todos cursos activos de un estudiante en especifico
    public ResponseEntity<?> listarTodosLosCursos(Long id) {
        Estudiante estudiante = buscarPorId(id);
        List<CursoRespuestaDTO> cursos = listaDeCursos(id);
        return ResponseEntity.ok(construirRespuestaDTO(estudiante, cursos));
    }

    // Lista todos cursos activos de un estudiante en especifico
    public ResponseEntity<?> listarCursosActivos(Long id) {
        Estudiante estudiante = buscarPorId(id);
        List<CursoRespuestaDTO> cursos = listaDeCursosActivos(id);
        return ResponseEntity.ok(construirRespuestaDTO(estudiante, cursos));
    }

    // Lista todos cursos eliminados de un estudiante en especifico
    public ResponseEntity<?> listarCursosEliminados(Long id) {
        Estudiante estudiante = buscarPorId(id);
        List<CursoRespuestaDTO> cursos = listaDeCursosEliminados(id);
        return ResponseEntity.ok(construirRespuestaDTO(estudiante, cursos));
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    public ResponseEntity<?> registrar (EstudiantePostDTO dto){
        EstudianteRespuestaDTO creado = registrarConValidacion(estudianteRepository.findByNombre(dto.nombre()).isPresent(), "Nombre del Estudiante ya esta registrado", dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    public ResponseEntity<?> editar(Long id, EstudianteUpdateDTO dto) {
        Estudiante estudiante = buscarPorId(id);

        if (estudiante.getEliminado()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El estudiante está eliminado");
        }

        Optional<Estudiante> existente = estudianteRepository.findByNombre(dto.nombre());
        if (existente.isPresent() && !existente.get().getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El nombre del estudiante ya está en uso");
        }

        EstudianteRespuestaDTO actualizado = super.actualizar(id, dto);

        return ResponseEntity.ok(actualizado);
    }

}