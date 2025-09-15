package Actividad3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    List<Estudiante> listaDeEstudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.listaDeEstudiantes = new ArrayList<>();
    }

    public void listarEstudiantes(Estudiante estudiante){
        listaDeEstudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + "\n" +
                "Estudiantes=" + "\n" + listaDeEstudiantes +
                '}';
    }
}
