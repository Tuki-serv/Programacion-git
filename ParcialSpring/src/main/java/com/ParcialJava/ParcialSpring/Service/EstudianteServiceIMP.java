package com.ParcialJava.ParcialSpring.Service;


import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudiantePostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Repositorys.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstudianteServiceIMP extends BaseServiceImpl<Estudiante, EstudiantePostDTO, EstudianteRespuestaDTO> implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    CursoMapper cursoMapper;

    @Override
    public ResponseEntity<?> registrar(EstudiantePostDTO dto) {
        boolean existe = estudianteRepository.existsByMatricula(dto.matricula());
        return registrarConValidacion(existe, "Ya existe un estudiante con esa matrícula", dto);
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
