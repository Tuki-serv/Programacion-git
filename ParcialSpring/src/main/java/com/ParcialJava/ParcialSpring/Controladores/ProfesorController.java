package com.ParcialJava.ParcialSpring.Controladores;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorUpdateDTO;
import com.ParcialJava.ParcialSpring.Service.InterfacesServicios.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping
    public List<ProfesorRespuestaDTO> listarTodos() {
        return profesorService.listarTodos();
    }

    @GetMapping("/activos")
    public List<ProfesorRespuestaDTO> listarActivos() {
        return profesorService.listarActivos();
    }

    @GetMapping("/eliminados")
    public List<ProfesorRespuestaDTO> listarEliminados() {
        return profesorService.listarEliminados();
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<?> listarCursos(@PathVariable Long id) {
        return profesorService.listarTodoLosCursos(id);
    }

    @GetMapping("/{id}/cursos/activos")
    public ResponseEntity<?> listarCursosActivos(@PathVariable Long id) {
        return profesorService.listarTodoLosCursosActivos(id);
    }

    @GetMapping("/{id}/cursos/eliminados")
    public ResponseEntity<?> listarCursosEliminados(@PathVariable Long id) {
        return profesorService.listarTodoLosCursosEliminados(id);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ProfesorPostDTO dto) {
        return profesorService.registrar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody ProfesorUpdateDTO dto) {
        return profesorService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reactivar")
    public ResponseEntity<?> reactivar(@PathVariable Long id) {
        return profesorService.reactivar(id);
    }
}
