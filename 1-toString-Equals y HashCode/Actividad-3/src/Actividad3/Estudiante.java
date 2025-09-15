package Actividad3;

public class Estudiante extends Persona{
    private String carrera;

    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" + super.toString() +
                "carrera='" + carrera + '\'' +
                "} "+ "\n";
    }
}
