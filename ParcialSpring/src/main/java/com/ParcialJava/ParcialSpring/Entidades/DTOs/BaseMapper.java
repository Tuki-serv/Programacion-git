package com.ParcialJava.ParcialSpring.Entidades.DTOs;

import com.ParcialJava.ParcialSpring.Entidades.Base;

import java.util.List;

public interface BaseMapper<Entidad, PostDTO, UpdateDTO, RespuestaDTO> {
    Entidad dtoToEntity(PostDTO dto);
    RespuestaDTO entityToDTO(Entidad entity);
    void actualizarEntidad(Entidad entidad, UpdateDTO dto);
    RespuestaDTO entityToDTO(Entidad entity, List<? extends Object> relacionados);

}
