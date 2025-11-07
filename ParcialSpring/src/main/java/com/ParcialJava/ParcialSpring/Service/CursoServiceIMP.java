package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoUpdateDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import com.ParcialJava.ParcialSpring.Repositorys.CursoRepository;
import com.ParcialJava.ParcialSpring.Repositorys.ProfesorRepository;
import com.ParcialJava.ParcialSpring.Service.InterfacesServicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceIMP extends BaseServiceIMP<Curso, CursoPostDTO, CursoUpdateDTO, CursoRespuestaDTO> implements CursoService {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    CursoMapper cursoMapper;
    @Autowired
    EstudianteServiceIMP estudianteServiceIMP;

/*---------------------------------------------------------------------------------------------------------------------*/
    // Este metodo sera utilizado por EstudianteServiceIMP
    public List<CursoRespuestaDTO> cursosListarPorEstudiante(Long estudianteId) {
        return mapear(cursoRepository.findByEstudiantesIdOrderByIdAsc(estudianteId));
    }

    // Este metodo sera utilizado por EstudianteServiceIMP
    public List<CursoRespuestaDTO> cursosActivosListarPorEstudiante(Long estudianteId) {
        return mapear(cursoRepository.findByEstudiantesIdAndEliminadoFalseOrderByIdAsc(estudianteId));
    }

    // Este metodo sera utilizado por EstudianteServiceIMP
    public List<CursoRespuestaDTO> cursosEliminadosListarPorEstudiante(Long estudianteId) {
        return mapear(cursoRepository.findByEstudiantesIdAndEliminadoTrueOrderByIdAsc(estudianteId));
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    // Recuperar todos los estudiantes de un curso
    public List<EstudianteRespuestaDTO> estudiantesDeCurso(Long cursoId) {
        return estudianteServiceIMP.estudiantesPorCurso(cursoId);
    }

    // Recuperar todos los estudiantes activos de un curso
    public List<EstudianteRespuestaDTO> estudiantesActivosDeCurso(Long cursoId) {
        return estudianteServiceIMP.estudiantesActivosPorCurso(cursoId);
    }

    // Recuperar todos los estudiantes eliminados de un curso
    public List<EstudianteRespuestaDTO> estudiantesEliminadosDeCurso(Long cursoId) {
        return estudianteServiceIMP.estudiantesEliminadosPorCurso(cursoId);
    }

/*---------------------------------------------------------------------------------------------------------------------*/



    // Este metodo sera utilizado por ProfesorServiceIMP para listar todos los cursos de un profesor
    public List<CursoRespuestaDTO> cursosListarProfesor(Long profesorId){
        return mapear(cursoRepository.findByProfesorIdOrderByIdAsc(profesorId));
    }

    // Este metodo sera utilizado por ProfesorServiceIMP para listar los cursos activos de un profesor
    public List<CursoRespuestaDTO> cursosListarProfesorActivos(Long profesorId){
        return mapear(cursoRepository.findByProfesorIdAndEliminadoFalseOrderByIdAsc(profesorId));
    }

    // Este metodo sera utilizado por ProfesorServiceIMP para listar los cursos eliminados de un profesor
    public List<CursoRespuestaDTO> cursosListarProfesorEliminado(Long profesorId){
        return mapear(cursoRepository.findByProfesorIdAndEliminadoTrueOrderByIdAsc(profesorId));
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    //Lista todos los cursos con todos sus estudiantes (activos y eliminados)
    @Override
    public List<CursoRespuestaDTO> listarTodos() {
        List<Curso> cursos = cursoRepository.findAllByOrderByIdAsc();
        return construirListaDeRespuestasDTO(cursos, this::estudiantesDeCurso);
    }

    // Lista todos los cursos activos con todos sus estudiantes
    public List<CursoRespuestaDTO> listarActivos() {
        List<Curso> cursos = cursoRepository.findByEliminadoFalseOrderByIdAsc();
        return construirListaDeRespuestasDTO(cursos, this::estudiantesDeCurso);
    }

    // Lista todos los cursos eliminados con todos sus estudiantes
    public List<CursoRespuestaDTO> listarEliminados() {
        List<Curso> cursos = cursoRepository.findByEliminadoTrueOrderByIdAsc();
        return construirListaDeRespuestasDTO(cursos, this::estudiantesDeCurso);
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    // Lista todos los estudiantes (activos y eliminados) de un curso específico
    public ResponseEntity<?> listarTodosLosEstudiantes(Long id) {
        Curso curso = buscarPorId(id);
        List<EstudianteRespuestaDTO> estudiantes = estudiantesDeCurso(id);
        return ResponseEntity.ok(construirRespuestaDTO(curso, estudiantes));
    }

    // Lista solo los estudiantes activos de un curso específico
    public ResponseEntity<?> listarEstudiantesActivos(Long id) {
        Curso curso = buscarPorId(id);
        List<EstudianteRespuestaDTO> estudiantes = estudiantesActivosDeCurso(id);
        return ResponseEntity.ok(construirRespuestaDTO(curso, estudiantes));
    }

    // Lista solo los estudiantes eliminados de un curso específico
    public ResponseEntity<?> listarEstudiantesEliminados(Long id) {
        Curso curso = buscarPorId(id);
        List<EstudianteRespuestaDTO> estudiantes = estudiantesEliminadosDeCurso(id);
        return ResponseEntity.ok(construirRespuestaDTO(curso, estudiantes));
    }


/*---------------------------------------------------------------------------------------------------------------------*/



    @Override
    public CursoRespuestaDTO crear(CursoPostDTO dto){
        Profesor profesor = profesorRepository.findById(dto.profesorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El profesor no existe"));

        if (profesor.getEliminado()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No se puede crear un Curso con un profesor elminado");
        }

        Curso curso = cursoMapper.dtoToEntity(dto);

        curso.vincularConProfesor(profesor);

        Curso guardado = cursoRepository.save(curso);

        return cursoMapper.entityToDTO(guardado);

    }

    @Override
    public ResponseEntity<?> registrar(CursoPostDTO dto) {
        boolean existe = cursoRepository.existsByNombreAndProfesorId(dto.nombre(), dto.profesorId());
        return ResponseEntity.ok(registrarConValidacion(existe, "Ya existe un curso con ese nombre con este Profesor", dto));
    }

    @Override
    public ResponseEntity<?> editar(Long id, CursoUpdateDTO dto) {
        Curso curso = buscarPorId(id);

        if (curso.getEliminado()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El curso está eliminada");
        }

        Optional<Curso> existente = cursoRepository.findByNombre(dto.nombre());
        if (existente.isPresent() && !existente.get().getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El nombre del curso ya está en uso");
        }

        CursoRespuestaDTO actualizado = super.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    public ResponseEntity<?> asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = buscarPorId(cursoId);
        Estudiante estudiante = estudianteServiceIMP.buscarPorId(estudianteId);

        if (curso.getEliminado() || estudiante.getEliminado()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Curso o estudiante eliminado");
        }

        curso.vincularConEstudiante(estudiante);

        return ResponseEntity.ok("Estudiante asignado correctamente");
    }
}
