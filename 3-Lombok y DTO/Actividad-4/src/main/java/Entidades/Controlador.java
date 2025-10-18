package Entidades;

import DTO.ProductoRecord;

import java.util.HashSet;
import java.util.Set;

public class Controlador {
    private final Servicio servicio;

    public Controlador (){
        this.servicio = new Servicio();
    }

    public void mostrarProductosRecord(){
        Set<ProductoRecord> productosRecord = listarProductosRecord();
        System.out.println("------------------------");
        System.out.println("Usando toSTring");
        System.out.println("");
        for (ProductoRecord p: productosRecord){
            System.out.println(p);
        }
        System.out.println("------------------------");
        System.out.println("Concatenando con getters");
        System.out.println("");
        for (ProductoRecord p: productosRecord){
            System.out.println("Codigo: " + p.codigo() + "| Nombre: " + p.nombre() + "| Precio: " + p.precio());
        }
    }

    private Set<ProductoRecord> listarProductosRecord(){
        Set<Producto> productos = servicio.listarProductos();
        Set<ProductoRecord> productosRecord = new HashSet<>();
        for (Producto p: productos){
            productosRecord.add(new ProductoRecord(p.getCodigo(),p.getNombre(),p.getPrecio()));
        }
        return productosRecord;
    }
}
