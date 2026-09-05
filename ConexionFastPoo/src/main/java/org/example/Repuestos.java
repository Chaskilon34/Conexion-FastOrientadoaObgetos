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

    /// getters

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    ///SETTERS con validación (ENCAPSULAMIENTO) ----
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        if (precio < 0) {
            System.out.println("Error: el precio no puede ser  nuemros negativo.");
        } else {
            this.precio = precio;
        }
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Error: el stock no puede ser  numeros negativo.");
        } else {
            this.stock = stock;
        }
    }

    @Override
    public String toString() {
        return "Repuesto " + nombre + "  Precio: $" + precio + "  Stock " + stock;
    }
}

void main() {
}