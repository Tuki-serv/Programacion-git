package com.ParcialJava.ParcialSpring.Controladores;

import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import com.ParcialJava.ParcialSpring.Service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<ProfesorRespuestaDTO> listarTodos() {
        return profesorService.listarTodos();
    }

    @GetMapping("/{id}/cursos")
    public List<CursoRespuestaDTO> cursosPorProfesor(@PathVariable Long id) {
        return profesorService.cursosPorProfesor(id);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody ProfesorPostDTO dto) {
        return profesorService.registrar(dto);
    }

    @PutMapping("/{id}")
    public ProfesorRespuestaDTO actualizar(@PathVariable Long id, @RequestBody ProfesorPostDTO dto) {
        return profesorService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Profesor> eliminado = profesorService.eliminar(id);
        if (eliminado.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");
        }
    }

}
