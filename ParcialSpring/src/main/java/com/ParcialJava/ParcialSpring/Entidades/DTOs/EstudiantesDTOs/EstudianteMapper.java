package com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;

public class EstudianteMapper implements BaseMapper<Estudiante, EstudiantePostDTO, EstudianteRespuestaDTO> {


    @Override
    public Estudiante dtoToEntity(EstudiantePostDTO dto) {
        Estudiante e = new Estudiante();
        e.setNombre(dto.nombre());
        e.setMatricula(dto.matricula());
        return e;
    }

    @Override
    public EstudianteRespuestaDTO entityToDTO(Estudiante entity) {
        return new EstudianteRespuestaDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getMatricula()
        );
    }

    @Override
    public void actualizarEntidad(Estudiante estudiante, EstudiantePostDTO dto) {
        if (dto.nombre() != null && !dto.nombre().isBlank() && !dto.nombre().equals(estudiante.getNombre())) {
            estudiante.setNombre(dto.nombre());
        }

        if (dto.matricula() != null && !dto.matricula().isBlank() && !dto.matricula().equals(estudiante.getMatricula())) {
            estudiante.setMatricula(dto.matricula());
        }
    }


}
