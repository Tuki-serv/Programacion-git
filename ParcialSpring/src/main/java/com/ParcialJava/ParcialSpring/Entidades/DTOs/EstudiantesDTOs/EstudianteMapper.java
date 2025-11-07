package com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudianteMapper implements BaseMapper<Estudiante, EstudiantePostDTO, EstudianteUpdateDTO, EstudianteRespuestaDTO> {

    @Override
    public Estudiante dtoToEntity(EstudiantePostDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.nombre());
        estudiante.setMatricula(dto.matricula());
        return estudiante;
    }

    @Override
    public EstudianteRespuestaDTO entityToDTO(Estudiante entity) {
        return new EstudianteRespuestaDTO(entity.getId(), entity.getNombre(), entity.getMatricula(), null);
    }

    @Override
    public void actualizarEntidad(Estudiante estudiante, EstudianteUpdateDTO dto) {
        if (dto.nombre() != null && !dto.nombre().isBlank() && !dto.nombre().equals(estudiante.getNombre())) {
            estudiante.setNombre(dto.nombre());
        }

        if (dto.matricula() != null && !dto.matricula().isBlank() && !dto.matricula().equals(estudiante.getMatricula())) {
            estudiante.setMatricula(dto.matricula());
        }
    }

    @Override
    public EstudianteRespuestaDTO entityToDTO(Estudiante estudiante, List<?> listaDeCursos) {
        return new EstudianteRespuestaDTO(estudiante.getId(), estudiante.getNombre(), estudiante.getMatricula(), (List<CursoRespuestaDTO>) listaDeCursos);
    }
}
