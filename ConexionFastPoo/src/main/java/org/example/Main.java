package org.example;

public class Main {
    public static void main(String[] args) {
        // Arreglo de tipo Usuario (Clase Abstracta) para demostrar Polimorfismo
        Usuario[] usuarios = new Usuario[2];

        usuarios[0] = new Mecanico("Carlos Pérez", "carlos@taller.com", "Taller El Pits");
        usuarios[1] = new Proveedor("Distribuidora MotoRepuestos", "ventas@motorepuestos.com", "Local Central #4");

        System.out.println("=== DEMOSTRACIÓN DE POLIMORFISMO DE USUARIOS ===\n");

        for (Usuario u : usuarios) {
            u.mostrarMenu();
            System.out.println();
        }

        /// Parte de Inventario / Repuestos --- temporal para valida el correcto funcionamiento y que mis compañero lo pueden editar
        System.out.println("=== Funcionamiento de repuestos e inventario  ===   \n");

        /// crear obgetos inventario
        Inventario inventario = new Inventario();
        inventario.agregarRepuesto(new Repuestos("Guaya de freno  ", 15000, 10));
        inventario.agregarRepuesto(new Repuestos("Bujía", 8000, 20));

       ///llamarlos metodos para revisar la lista
        inventario.listarRepuestos();

        System.out.println("\nBuscando 'Bujía'...");
        Repuestos encontrado = inventario.buscarPorNombre("Bujía");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado); ///encontro el objeto buscado antes con el metodo   inventario.buscarPorNombre
        } else {
            System.out.println("No se encontró el repuesto.");  ///lo que ejecuta el null cunado no encuentra nada
        }
    }
}
