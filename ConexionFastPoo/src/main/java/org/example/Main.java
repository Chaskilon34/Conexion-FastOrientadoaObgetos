package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();


        inventario.agregarRepuesto(new Repuestos("Guaya de freno", 15000, 10));
        inventario.agregarRepuesto(new Repuestos("Bujía", 8000, 20));
        inventario.agregarRepuesto(new Repuestos("Filtro de aceite", 12000, 15));

        System.out.println("==========================================");
        System.out.println("     SISTEMA DE GESTIÓN DE REPUESTOS     ");
        System.out.println("==========================================");
        System.out.println("¿Qué tipo de usuario eres?");
        System.out.println("1. Mecánico");
        System.out.println("2. Proveedor");
        System.out.print("Selecciona una opción (1 o 2): ");

        int tipoUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Usuario usuario = null;


        if (tipoUsuario == 1) {
            usuario = new Mecanico("Mecánico", "mecanico@taller.com", "Taller Central");
            System.out.println("\n Has iniciado sesión como MECÁNICO\n");
        } else if (tipoUsuario == 2) {
            usuario = new Proveedor("Proveedor", "proveedor@distribuidora.com", "Local Principal");
            System.out.println("\n Has iniciado sesión como PROVEEDOR\n");
        } else {
            System.out.println("Opción no válida. Saliendo del sistema...");
            scanner.close();
            return;
        }


        boolean salir = false;
        while (!salir) {
            usuario.mostrarMenu();
            System.out.print("\nSelecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (tipoUsuario == 1) {

                        System.out.print("Ingresa el nombre del repuesto a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        Repuestos encontrado = inventario.buscarPorNombre(nombreBuscar);
                        if (encontrado != null) {
                            System.out.println("Encontrado: " + encontrado);
                        } else {
                            System.out.println("No se encontró el repuesto.");
                        }
                    } else {

                        System.out.println("PUBLICAR NUEVO REPUESTO");
                        System.out.print("Nombre del repuesto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Precio: ");
                        int precio = scanner.nextInt();
                        System.out.print("Stock: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine();

                        inventario.agregarRepuesto(new Repuestos(nombre, precio, stock));
                        System.out.println("Repuesto publicado exitosamente!");
                    }
                    break;

                case 2:
                    if (tipoUsuario == 1) {

                        System.out.println("PROVEEDORES DISPONIBLES:");
                        System.out.println("- Distribuidora MotoRepuestos");
                        System.out.println("- Autopartes El Turbo");
                        System.out.println("- Repuestos rápidos SAS");
                        System.out.println("(Función en desarrollo)");
                    } else {

                        System.out.println("LISTA DE REPUESTOS EN INVENTARIO:");
                        inventario.listarRepuestos();
                    }
                    break;

                case 3:
                    if (tipoUsuario == 1) {

                        System.out.println("CREAR ORDEN DE COMPRA");
                        System.out.print("Ingresa el nombre del repuesto: ");
                        String nombreCompra = scanner.nextLine();
                        Repuestos repuestoCompra = inventario.buscarPorNombre(nombreCompra);
                        if (repuestoCompra != null) {
                            System.out.print("Cantidad: ");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Orden creada: " + cantidad + " x " + repuestoCompra.getNombre());
                            System.out.println("Total: $" + (repuestoCompra.getPrecio() * cantidad));
                        } else {
                            System.out.println("Repuesto no encontrado.");
                        }
                    } else {

                        System.out.println(" PEDIDOS RECIBIDOS DE TALLERES:");
                        System.out.println("- Taller El Pits: 5 guayas de freno");
                        System.out.println("- Taller Mecánico: 10 bujías");
                        System.out.println("(Función en desarrollo)");
                    }
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

            if (!salir) {
                System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
            }
        }
        scanner.close();
        System.out.println("Sistema finalizado.");
    }
}
