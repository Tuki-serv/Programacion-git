import Actividad1.Estudiante;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Estudiante p1 = new Estudiante("Juan",20,"Ingeniería en Sistemas");
        Estudiante p2 = new Estudiante("María",22,"Diseño Gráfico");
        Estudiante p3 = new Estudiante("Pedro",21,"Medicina");

        ArrayList<Estudiante> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        for (Estudiante i: lista){
            System.out.println(i);
        }
    }
}