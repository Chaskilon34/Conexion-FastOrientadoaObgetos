package org.example;

public class Main {
    public static void main(String[] args) {
        // Arreglo de tipo Usuario (Clase Abstracta) para demostrar Polimorfismo
        Usuario[] usuarios = new Usuario[2];

        usuarios[0] = new Mecanico("Carlos Pérez", "carlos@taller.com", "Taller El Pits");
        usuarios[1] = new Proveedor("Distribuidora MotoRepuestos", "ventas@motorepuestos.com", "Local Central #4");

        System.out.println("=== DEMOSTRACIÓN DE POLIMORFISMO DE USUARIOS  ===\n");

        // Ejecución dinámica del método mostrarMenu() según el tipo de usuario
        for (Usuario u : usuarios) {
            u.mostrarMenu();
            System.out.println();
        }
    }
}