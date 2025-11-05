package com.ParcialJava.ParcialSpring.Entidades.DTOs;

import com.ParcialJava.ParcialSpring.Entidades.Base;

public interface BaseMapper<Entidad, PostDTO, RespuestaDTO> {
    Entidad dtoToEntity(PostDTO dto);
    RespuestaDTO entityToDTO(Entidad entity);
    void actualizarEntidad(Entidad entidad, PostDTO dto);
}
