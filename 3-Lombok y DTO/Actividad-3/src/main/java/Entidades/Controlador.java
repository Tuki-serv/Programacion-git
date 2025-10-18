package Entidades;

import DTO.ProductoDTO;

import java.util.HashSet;
import java.util.Set;

public class Controlador {
    private final Servicio servicio;

    public Controlador() {
        this.servicio = new Servicio();
    }

    public void mostrarProductosDTO(){
        Set <ProductoDTO> listaProductosDTO = listarProductosDTO();
        for (ProductoDTO p : listaProductosDTO){
            System.out.println(p);
        }
    }

    private Set<ProductoDTO> listarProductosDTO(){
        Set<Producto> listaProductos = servicio.listarProductos();
        Set<ProductoDTO> productoDTOS = new HashSet<>();
        for (Producto p: listaProductos){
            productoDTOS.add(new ProductoDTO(p.getCodigo(),p.getNombre(), p.getPrecio()));
        }
        return productoDTOS;
    }

}
