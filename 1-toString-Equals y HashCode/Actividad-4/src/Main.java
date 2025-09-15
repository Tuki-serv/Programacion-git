import Actividad4.Producto;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("1","Lavarropas",1500);
        Producto p2 = new Producto("2","Microondas",200);
        Producto p3 = new Producto("1","Lavarropas Automatico",1200);
        Producto p4 = new Producto("3","Heladera",5000);

        List<Producto> lista = new ArrayList<>();

        if (!lista.contains(p1)){
            lista.add(p1);
        }else {
            System.out.println("El producto" + p1 + "\n" + " ya se encuentra en la lista");
        }

        if (!lista.contains(p2)){
            lista.add(p2);
        }else {
            System.out.println("El producto" + p2 + "\n" + " ya se encuentra en la lista");
        }

        if (!lista.contains(p3)){
            lista.add(p3);
        }else {
            System.out.println("El producto" + p3 + "\n" + " ya se encuentra en la lista");
        }

        if (!lista.contains(p4)){
            lista.add(p4);
        }else {
            System.out.println("El producto" + p4 + "\n" + " ya se encuentra en la lista");
        }

        System.out.println("-------------------------------------------------");

        for (Producto p: lista){
            System.out.println(p);
        }
    }
}