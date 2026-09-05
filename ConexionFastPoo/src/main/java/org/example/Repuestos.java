package org.example;

public class Repuestos {
    private String nombre;
    private int precio;
    private int stock;

    public Repuestos(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /// Metodos  GET
    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    /// Metodos Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    ///  validar que el precio no tenga ningun numero negativo
    public void setPrecio(int precio) {
        if (precio < 0) {
            System.out.println("Error: el precio no puede ser negativo.");
        } else {
            this.precio = precio;
        }
    }
    /// validar que el Stock no tenga ningun numero negativo
    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Error: el stock no puede ser negativo.");
        } else {
            this.stock = stock;
        }
    }
 /// toString es un metodo especial para  leer las 3 variables ya declaradas y las convina en un texto legible para la consola
    @Override
    public String toString() {
        return "Repuesto: " + nombre + "  Precio: $" + precio + "  Stock: " + stock;
    }
}
