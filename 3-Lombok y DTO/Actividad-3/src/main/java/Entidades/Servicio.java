package Entidades;

import java.util.HashSet;
import java.util.Set;

public class Servicio {
    private Set<Producto> productos = new HashSet<>();

    public Servicio() {
        productos.add(new Producto("P001", "Teclado Mecánico", 4500.0, "Logitech"));
        productos.add(new Producto("P002", "Monitor 24''", 32000.0, "Samsung"));
        productos.add(new Producto("P003", "Mouse Inalámbrico", 2800.0, "HP"));
        productos.add(new Producto("P004", "Auriculares Gamer", 7500.0, "HyperX"));
        productos.add(new Producto("P005", "Notebook i7", 250000.0, "Lenovo"));
    }

    public Set<Producto> listarProductos(){
        return productos;
    }
}
