import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("1","Lavarropas");
        Producto p2 = new Producto("2","Microondas");
        Producto p3 = new Producto("1","Lavarropas Automatico");
        Producto p4 = new Producto("3","Heladera");

        Set<Producto> productos = new HashSet<>();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        for (Producto p: productos){
            System.out.println(p);
        }
    }
}