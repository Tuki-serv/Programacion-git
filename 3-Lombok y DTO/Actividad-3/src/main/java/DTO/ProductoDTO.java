package DTO;

import java.util.Objects;

public class ProductoDTO {
    private String codigo;
    private String nombre;
    private double precio;

    public ProductoDTO(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoDTO that = (ProductoDTO) o;
        return Double.compare(precio, that.precio) == 0 && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio);
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "| codigo='" + codigo + '\'' +
                "| nombre='" + nombre + '\'' +
                "| precio=" + precio +
                '}';
    }
}
