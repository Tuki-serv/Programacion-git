package com.ParcialJava.ParcialSpring.Controladores;


import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudiantePostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteUpdateDTO;
import com.ParcialJava.ParcialSpring.Service.InterfacesServicios.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<EstudianteRespuestaDTO> listarTodos() {
        return estudianteService.listarTodos();
    }

    @GetMapping("/activos")
    public List<EstudianteRespuestaDTO> listarActivos() {
        return estudianteService.listarActivos();
    }

    @GetMapping("/eliminados")
    public List<EstudianteRespuestaDTO> listarEliminados() {
        return estudianteService.listarEliminados();
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<?> listarCursos(@PathVariable Long id) {
        return estudianteService.listarTodosLosCursos(id);
    }

    @GetMapping("/{id}/cursos/activos")
    public ResponseEntity<?> listarCursosActivos(@PathVariable Long id) {
        return estudianteService.listarCursosActivos(id);
    }

    @GetMapping("/{id}/cursos/eliminados")
    public ResponseEntity<?> listarCursosEliminados(@PathVariable Long id) {
        return estudianteService.listarCursosEliminados(id);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody EstudiantePostDTO dto) {
        return estudianteService.registrar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody EstudianteUpdateDTO dto) {
        return estudianteService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reactivar")
    public ResponseEntity<?> reactivar(@PathVariable Long id) {
        return estudianteService.reactivar(id);
    }
}
