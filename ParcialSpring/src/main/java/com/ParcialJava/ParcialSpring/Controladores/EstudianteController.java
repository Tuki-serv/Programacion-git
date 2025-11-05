package com.ParcialJava.ParcialSpring.Controladores;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudiantePostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs.EstudianteRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Estudiante;
import com.ParcialJava.ParcialSpring.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<EstudianteRespuestaDTO> listarTodos() {
        return estudianteService.listarTodos();
    }

    @GetMapping("/{id}/cursos")
    public List<CursoRespuestaDTO> cursosPorEstudiante(@PathVariable Long id) {
        return estudianteService.cursosPorEstudiante(id);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody EstudiantePostDTO dto) {
        return estudianteService.registrar(dto);
    }

    @PutMapping("/{id}")
    public EstudianteRespuestaDTO actualizar(@PathVariable Long id, @RequestBody EstudiantePostDTO dto) {
        return estudianteService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Estudiante> eliminado = estudianteService.eliminar(id);
        if (eliminado.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
        }
    }
}
