import Actividad3.Curso;
import Actividad3.Estudiante;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Estudiante p1 = new Estudiante("Juan",20,"Ingeniería en Sistemas");
        Estudiante p2 = new Estudiante("María",22,"Diseño Gráfico");
        Estudiante p3 = new Estudiante("Pedro",21,"Medicina");

        Curso curso = new Curso("Aritmetica");
        curso.listarEstudiantes(p1);
        curso.listarEstudiantes(p2);
        curso.listarEstudiantes(p3);

        System.out.println(curso);
    }
}