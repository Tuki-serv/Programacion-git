package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.Base;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ErrorDTO;
import com.ParcialJava.ParcialSpring.Repositorys.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, DTOPost, DTORespuesta> implements BaseService<E, DTOPost, DTORespuesta> {

    @Autowired
    protected BaseRepository<E, Long> baseRepository;

    @Autowired
    protected BaseMapper<E, DTOPost, DTORespuesta> baseMapper;

    @Override
    public List<DTORespuesta> listarTodos() {
        return mapear(baseRepository.findAllByOrderByIdAsc());
    }

    @Override
    public List<DTORespuesta> listarActivos() {
        return mapear(baseRepository.findByEliminadoFalseOrderByIdAsc());
    }

    @Override
    public List<DTORespuesta> listarEliminados() {
        return mapear(baseRepository.findByEliminadoTrueOrderByIdAsc());
    }

    @Override
    public DTORespuesta crear(DTOPost dtoCreate) {
        E entidad = baseMapper.dtoToEntity(dtoCreate);
        entidad = baseRepository.save(entidad);
        return baseMapper.entityToDTO(entidad);
    }

    @Override
    public DTORespuesta actualizar(Long id, DTOPost dtoPost) {
        Optional<E> entidadOpt = baseRepository.findById(id);
        if (entidadOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entidad no encontrada con id: " + id);
        }

        E entidad = entidadOpt.get();
        baseMapper.actualizarEntidad(entidad, dtoPost);
        entidad = baseRepository.save(entidad);
        return baseMapper.entityToDTO(entidad);
    }

    @Override
    public Optional<E> eliminar(Long id) {
        Optional<E> entidadOpt = baseRepository.findById(id);
        if (entidadOpt.isEmpty()) {
            return Optional.empty();
        }

        E entidad = entidadOpt.get();
        entidad.setEliminado(true);
        entidad = baseRepository.save(entidad);
        return Optional.of(entidad);
    }

    @Override
    public ResponseEntity<?> reactivar(Long id) {
        Optional<E> entidadOpt = baseRepository.findById(id);
        if (entidadOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDTO("Estado: inexistente"));
        }

        E entidad = entidadOpt.get();
        if (!entidad.getEliminado()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorDTO("Estado: Activado"));
        }

        entidad.setEliminado(false);
        baseRepository.save(entidad);
        return ResponseEntity.ok(baseMapper.entityToDTO(entidad));
    }


    protected List<DTORespuesta> mapear(List<E> entidades) {
        return entidades.stream()
                .map(baseMapper::entityToDTO)
                .toList();
    }

    protected ResponseEntity<?> registrarConValidacion(boolean existe, String mensajeError, DTOPost dto) {
        if (existe) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(mensajeError));
        }
        DTORespuesta creado = crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    protected ResponseEntity<?> editarConValidacion(Optional<? extends Base> existente, Long id, String mensajeError, DTOPost dto) {
        if (existente.isPresent() && !existente.get().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(mensajeError));
        }
        DTORespuesta actualizado = actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
