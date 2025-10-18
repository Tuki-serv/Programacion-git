package Entidades;

import java.util.HashSet;
import java.util.Set;

public class Servicio {
    private Set<Producto> productos = new HashSet<>();

    public Servicio() {
        productos.add(new Producto("P001", "Teclado Mecánico", "Logitech", 4500.0));
        productos.add(new Producto("P002", "Monitor 24''", "Samsung", 32000.0));
        productos.add(new Producto("P003", "Mouse Inalámbrico", "HP", 2800.0));
        productos.add(new Producto("P004", "Auriculares Gamer", "HyperX", 7500.0));
        productos.add(new Producto("P005", "Notebook i7", "Lenovo", 250000.0));
    }

    public Set<Producto> listarProductos(){
        return productos;
    }
}
