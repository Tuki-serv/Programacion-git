package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.Base;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<E extends Base, DTOPost, DTORespuesta> {
    List<DTORespuesta> listarTodos();
    List<DTORespuesta> listarActivos();
    List<DTORespuesta> listarEliminados();
    DTORespuesta crear(DTOPost dtoCreate);
    DTORespuesta actualizar(Long id, DTOPost dtoPost);
    Optional<E> eliminar(Long id);
    ResponseEntity<?> reactivar(Long id);
}
