package com.ParcialJava.ParcialSpring.Service.InterfacesServicios;

import com.ParcialJava.ParcialSpring.Entidades.Base;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<E extends Base, PostDTO, UpdateDTO, RespuestaDTO> {
    E buscarPorId(Long id);
    List<RespuestaDTO> listarTodos();
    RespuestaDTO crear(PostDTO dto);
    RespuestaDTO actualizar(Long id, UpdateDTO dto);
    void eliminar(Long id);
    ResponseEntity<?> reactivar(Long id);

}
