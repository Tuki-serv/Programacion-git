package Reflections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }

    public void saludar(){
        System.out.println("Hola");
    }

}
