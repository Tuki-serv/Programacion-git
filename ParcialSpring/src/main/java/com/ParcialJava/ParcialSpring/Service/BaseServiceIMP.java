package com.ParcialJava.ParcialSpring.Service;

import com.ParcialJava.ParcialSpring.Entidades.Base;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.BaseMapper;
import com.ParcialJava.ParcialSpring.Repositorys.BaseRepository;
import com.ParcialJava.ParcialSpring.Service.InterfacesServicios.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public abstract class BaseServiceIMP<Entidad extends Base, PostDTO, UpdateDTO, RespuestaDTO> implements BaseService<Entidad, PostDTO, UpdateDTO, RespuestaDTO> {

    @Autowired
    protected BaseRepository<Entidad, Long> baseRepository;

    @Autowired
    protected BaseMapper<Entidad, PostDTO, UpdateDTO, RespuestaDTO> baseMapper;

    @Override
    public Entidad buscarPorId(Long id){
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro"));
    };

    protected List<RespuestaDTO> mapear(List<Entidad> entidades) {
        return entidades.stream()
                .map(baseMapper::entityToDTO)
                .toList();
    }

    protected RespuestaDTO registrarConValidacion(boolean existe, String mensajeError, PostDTO dto) {
        if (existe) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensajeError);
        }
        return crear(dto);
    }


    @Override
    public RespuestaDTO crear(PostDTO dto) {
        Entidad e = baseMapper.dtoToEntity(dto);
        e = baseRepository.save(e);
        return baseMapper.entityToDTO(e);
    }

    public RespuestaDTO actualizar(Long id, UpdateDTO dto){
        Entidad entidad = buscarPorId(id);

        baseMapper.actualizarEntidad(entidad, dto);
        entidad = baseRepository.save(entidad);

        return baseMapper.entityToDTO(entidad);
    }

    @Override
    public void eliminar(Long id) {
        Entidad entidad = buscarPorId(id);

        entidad.setEliminado(true);
        entidad = baseRepository.save(entidad);
    }

    @Override
    public ResponseEntity<?> reactivar(Long id) {
        Entidad entidad = buscarPorId(id);

        if (!entidad.getEliminado()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Estado: Activado");
        }

        entidad.setEliminado(false);
        baseRepository.save(entidad);

        return ResponseEntity.ok(baseMapper.entityToDTO(entidad));
    }


    protected List<RespuestaDTO> construirListaDeRespuestasDTO(List<Entidad> entidades, Function<Long, List<?>> buscarRelacionados) {
        List<RespuestaDTO> listaRespuestas = new ArrayList<>();
        for (Entidad entidad : entidades) {
            RespuestaDTO dto = construirRespuestaDTO(entidad, buscarRelacionados);
            listaRespuestas.add(dto);
        }
        return listaRespuestas;
    }

    protected RespuestaDTO construirRespuestaDTO(Entidad entidad, Function<Long, List<? extends Object>> buscarRelacionados) {
        return baseMapper.entityToDTO(entidad, buscarRelacionados.apply(entidad.getId()));
    }

    protected RespuestaDTO construirRespuestaDTO(Entidad entidad, List<? extends Object> relacionados) {
        return baseMapper.entityToDTO(entidad, relacionados);
    }


//    // Funcion que crea que crea una lista de CategoriaRespuestaDTO junto con la lista de productos pertienentes
//    private List<RespuestaDTO> construirListaDeRespuestasDTO(List<Entidad> entidades, Function<Long, List<CursoRespuestaDTO>> buscarCursos
//    ){
//        List<RespuestaDTO> listaRespuestas = new ArrayList<>();
//        for (Entidad entidad: entidades){
//            // soy re copado, pase un metodo como parametro ajajajajajaj
//            RespuestaDTO dto = construirProfesorRespuestaDTO(entidad, buscarCursos);
//            listaRespuestas.add(dto);
//        }
//        return listaRespuestas;
//    }
//
//    // Funcion que crea una instancia de CategoriaRespuestaDTO
//    private RespuestaDTO construirProfesorRespuestaDTO(Entidad entidad, Function<Long, List<RespuestaDTO>> buscarCursos){
//        return baseMapper.entityToDTO(entidad,buscarCursos.apply(entidad.getId()));
//    }
}
