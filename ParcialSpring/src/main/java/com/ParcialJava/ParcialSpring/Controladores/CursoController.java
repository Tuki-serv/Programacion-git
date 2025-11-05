package com.ParcialJava.ParcialSpring.Controladores;

import com.ParcialJava.ParcialSpring.Entidades.Curso;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoRespuestaDTO> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/estudiante/{id}")
    public List<CursoRespuestaDTO> cursosPorEstudiante(@PathVariable Long id) {
        return cursoService.cursosPorEstudiante(id);
    }

    @PostMapping
    public CursoRespuestaDTO crear(@RequestBody CursoPostDTO dto) {
        return cursoService.crear(dto);
    }

    @PutMapping("/{id}")
    public CursoRespuestaDTO actualizar(@PathVariable Long id, @RequestBody CursoPostDTO dto) {
        return cursoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Curso> eliminado = cursoService.eliminar(id);
        if (eliminado.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso no encontrado");
        }
    }

    @PutMapping("/{cursoId}/asignar/{estudianteId}")
    public ResponseEntity<?> asignarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        cursoService.asignarEstudiante(cursoId, estudianteId);
        return ResponseEntity.ok().build();
    }
}
