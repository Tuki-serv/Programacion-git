import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Alumno a1 = new Alumno("Pepe",10);
        Alumno a2 = new Alumno("Laura",5);
        Alumno a3 = new Alumno("Julio",8);

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(a1);
        alumnos.add(a2);
        alumnos.add(a3);

        for(Alumno a: alumnos){
            System.out.println(a);
        }
    }
}