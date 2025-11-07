package com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoMapper implements BaseMapper<Curso, CursoPostDTO, CursoUpdateDTO, CursoRespuestaDTO> {

    @Override
    public Curso dtoToEntity(CursoPostDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.nombre());
        return curso;
    }

    @Override
    public CursoRespuestaDTO entityToDTO(Curso entity) {
        Long profesorId = entity.getProfesor() != null ? entity.getProfesor().getId() : null;
        return new CursoRespuestaDTO(entity.getId(), entity.getNombre(), profesorId, null);
    }

    @Override
    public void actualizarEntidad(Curso curso, CursoUpdateDTO dto) {
        if (dto.nombre() != null && !dto.nombre().isBlank() && !dto.nombre().equals(curso.getNombre())) {
            curso.setNombre(dto.nombre());
        }
    }

    @Override
    public CursoRespuestaDTO entityToDTO(Curso curso, List<?> listaDeEstudiantes) {
        return new CursoRespuestaDTO(curso.getId(), curso.getNombre(), curso.getProfesor().getId(), (List<EstudianteRespuestaDTO>) listaDeEstudiantes);
    }
}
