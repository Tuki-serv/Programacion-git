import Actividad5.Producto;

import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("1","Lavarropas",1500);
        Producto p2 = new Producto("2","Microondas",200);
        Producto p3 = new Producto("1","Lavarropas Automatico",1200);
        Producto p4 = new Producto("3","Heladera",5000);

        Set<Producto> listaSet = new HashSet<>();

        listaSet.add(p1);
        listaSet.add(p2);
        listaSet.add(p3);
        listaSet.add(p4);

        System.out.println("Tamaño del lista: "+listaSet.size());
        System.out.println(listaSet);
    }
}