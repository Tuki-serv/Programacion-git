package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import com.ParcialJava.ParcialSpring.Repositorys.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ProfesorServiceIMP extends BaseServiceImpl<Profesor, ProfesorPostDTO, ProfesorRespuestaDTO> implements ProfesorService{
    @Autowired
    ProfesorMapper profesorMapper;
    @Autowired
    ProfesorRepository profesorRepository;



    @Override
    public ResponseEntity<?> registrar(ProfesorPostDTO dto) {
        boolean existe = profesorRepository.existsByEmail(dto.email());
        return registrarConValidacion(existe, "Ya existe un profesor con ese email", dto);
    }


    @Autowired
    CursoMapper cursoMapper;

    @Override
    public List<CursoRespuestaDTO> cursosPorProfesor(Long profesorId) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesor no encontrado"));

        return profesor.getCursos().stream()
                .map(cursoMapper::entityToDTO)
                .toList();
    }

}
