package com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfesorMapper implements BaseMapper<Profesor, ProfesorPostDTO, ProfesorUpdateDTO, ProfesorRespuestaDTO> {

    @Override
    public Profesor dtoToEntity(ProfesorPostDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.nombre());
        profesor.setEmail(dto.email());
        return profesor;
    }

    @Override
    public ProfesorRespuestaDTO entityToDTO(Profesor profesor) {
        return new ProfesorRespuestaDTO(profesor.getId(), profesor.getNombre(), profesor.getEmail(), null);
    }

    @Override
    public void actualizarEntidad(Profesor profesor, ProfesorUpdateDTO dto) {
        if (dto.nombre() != null && !dto.nombre().isBlank() && !dto.nombre().equals(profesor.getNombre())) {
            profesor.setNombre(dto.nombre());
        }

        if (dto.email() != null && !dto.email().isBlank() && !dto.email().equals(profesor.getEmail())) {
            profesor.setEmail(dto.email());
        }
    }

    @Override
    public ProfesorRespuestaDTO entityToDTO(Profesor profesor, List<?> listaDeCursos) {
        return new ProfesorRespuestaDTO(profesor.getId(),profesor.getNombre(),profesor.getEmail(),(List<CursoRespuestaDTO>) listaDeCursos);
    }
}
