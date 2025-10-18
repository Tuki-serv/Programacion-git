import java.util.Objects;

public class Curso {
    private String nombre;
    private String docente;

    public Curso(String nombre, String docente) {
        this.nombre = nombre;
        this.docente = docente;
    }

    @Override
    public String toString() {
        return "Curso{" +
                " nombre='" + nombre + '\'' +
                ", docente='" + docente + '\'' +
                '}';
    }


}
