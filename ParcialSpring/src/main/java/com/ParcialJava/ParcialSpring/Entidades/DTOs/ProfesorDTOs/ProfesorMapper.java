package com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;

import java.util.ArrayList;

public class ProfesorMapper implements BaseMapper<Profesor,ProfesorPostDTO, ProfesorRespuestaDTO > {
    @Override
    public Profesor dtoToEntity(ProfesorPostDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.nombre());
        profesor.setEmail(dto.email());
        return profesor;
    }

    @Override
    public ProfesorRespuestaDTO entityToDTO(Profesor entity) {
        return new ProfesorRespuestaDTO(entity.getId(), entity.getNombre(), entity.getEmail());
    }

    @Override
    public void actualizarEntidad(Profesor profesor, ProfesorPostDTO dto) {
        if (dto.nombre() != null && !dto.nombre().isBlank() && !dto.nombre().equals(profesor.getNombre())) {
            profesor.setNombre(dto.nombre());
        }

        if (dto.email() != null && !dto.email().isBlank() && !dto.email().equals(profesor.getEmail())) {
            profesor.setEmail(dto.email());
        }
    }



}
