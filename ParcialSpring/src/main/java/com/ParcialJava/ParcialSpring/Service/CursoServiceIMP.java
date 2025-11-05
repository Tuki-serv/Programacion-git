package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import com.ParcialJava.ParcialSpring.Repositorys.CursoRepository;
import com.ParcialJava.ParcialSpring.Repositorys.EstudianteRepository;
import com.ParcialJava.ParcialSpring.Repositorys.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CursoServiceIMP extends BaseServiceImpl<Curso, CursoPostDTO, CursoRespuestaDTO> implements CursoService {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    CursoMapper cursoMapper;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public CursoRespuestaDTO crear(CursoPostDTO dto) {
        Profesor profesor = profesorRepository.findById(dto.profesorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El profesor no existe"));

        Curso curso = cursoMapper.dtoToEntity(dto);
        curso.setProfesor(profesor);

        Curso guardado = cursoRepository.save(curso);
        return cursoMapper.entityToDTO(guardado);
    }

    @Override
    public void asignarEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));

        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado"));

        if (!curso.getEstudiantes().contains(estudiante)) {
            curso.getEstudiantes().add(estudiante);
        }
        if (!estudiante.getCursos().contains(curso)) {
            estudiante.getCursos().add(curso);
        }

        cursoRepository.save(curso);
        estudianteRepository.save(estudiante);
    }

    @Override
    public List<CursoRespuestaDTO> cursosPorEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado"));

        return estudiante.getCursos().stream()
                .map(cursoMapper::entityToDTO)
                .toList();
    }
}
