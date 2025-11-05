package com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper implements BaseMapper<Curso, CursoPostDTO, CursoRespuestaDTO> {

    @Override
    public Curso dtoToEntity(CursoPostDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.nombre());
        return curso;
    }

    @Override
    public CursoRespuestaDTO entityToDTO(Curso curso) {
        return new CursoRespuestaDTO(curso.getId(), curso.getNombre(), curso.getProfesor(), curso.getEstudiantes());
    }

    @Override
    public void actualizarEntidad(Curso curso, CursoPostDTO dto) {
        if (dto.nombre() != null && !dto.nombre().isBlank() && !dto.nombre().equals(curso.getNombre())) {
            curso.setNombre(dto.nombre());
        }
    }
}
