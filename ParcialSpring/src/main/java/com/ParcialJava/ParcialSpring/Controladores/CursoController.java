package com.ParcialJava.ParcialSpring.Controladores;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.*;
import com.ParcialJava.ParcialSpring.Service.InterfacesServicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    // Listar todos los cursos con sus estudiantes
    @GetMapping
    public List<CursoRespuestaDTO> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/activos")
    public List<CursoRespuestaDTO> listarActivos() {
        return cursoService.listarActivos();
    }

    @GetMapping("/eliminados")
    public List<CursoRespuestaDTO> listarEliminados() {
        return cursoService.listarEliminados();
    }

    @GetMapping("/{id}/estudiantes")
    public ResponseEntity<?> listarEstudiantes(@PathVariable Long id) {
        return cursoService.listarTodosLosEstudiantes(id);
    }

    @GetMapping("/{id}/estudiantes/activos")
    public ResponseEntity<?> listarEstudiantesActivos(@PathVariable Long id) {
        return cursoService.listarEstudiantesActivos(id);
    }

    @GetMapping("/{id}/estudiantes/eliminados")
    public ResponseEntity<?> listarEstudiantesEliminados(@PathVariable Long id) {
        return cursoService.listarEstudiantesEliminados(id);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CursoPostDTO dto) {
        return cursoService.registrar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody CursoUpdateDTO dto) {
        return cursoService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reactivar")
    public ResponseEntity<?> reactivar(@PathVariable Long id) {
        return cursoService.reactivar(id);
    }

    @PutMapping("/{cursoId}/asignar/{estudianteId}")
    public ResponseEntity<?> asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        return cursoService.asignarEstudiante(cursoId, estudianteId);
    }
}
