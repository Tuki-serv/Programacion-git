package Entidades;

import java.util.Objects;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private String autor;

    public Producto(String codigo, String nombre, double precio, String autor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(precio, producto.precio) == 0 && Objects.equals(codigo, producto.codigo) && Objects.equals(nombre, producto.nombre) && Objects.equals(autor, producto.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, autor);
    }
}
