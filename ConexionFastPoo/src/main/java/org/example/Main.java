package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Arreglo de tipo Usuario (Clase Abstracta) para demostrar Polimorfismo
        Usuario[] usuarios = new Usuario[3];
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
       /// poliformismo
       usuarios[0] = new Mecanico("Carlos Pérez", "carlos@taller.com", "Taller El Pits");
       usuarios[1] = new Proveedor("Distribuidora MotoRepuestos", "ventas@motorepuestos.com", "Local Central #4");
       usuarios[2] = new Administrador("Juan David", "admin@conexionparts.com", "Súper Admin");

        System.out.println("=== DEMOSTRACIÓN DE POLIMORFISMO DE USUARIOS ===\n");
        inventario.agregarRepuesto(new Repuestos("Guaya de freno", 15000, 10));
        inventario.agregarRepuesto(new Repuestos("Bujía", 8000, 20));
        inventario.agregarRepuesto(new Repuestos("Filtro de aceite", 12000, 15));
        /// bucle de poliformismo
        for (Usuario u : usuarios) {
            u.mostrarMenu();
            System.out.println("Rol: " + u.getRol());
            System.out.println("Acción Principal: ");
            u.realizarAccionPrincipal();
            System.out.println("Beneficio: $" + u.calcularBeneficio());
            System.out.println("¿Permiso Especial?: " + u.tienePermisoEspecial());
            System.out.println("\n------------------------------------------\n");
        }

        System.out.println("==========================================");
        System.out.println("     SISTEMA DE GESTIÓN DE REPUESTOS     ");
        System.out.println("==========================================");
        System.out.println("¿Qué tipo de usuario eres?");
        System.out.println("1. Mecánico");
        System.out.println("2. Proveedor");
        System.out.print("Selecciona una opción (1 o 2): ");

        /// Parte de Inventario / Repuestos --- temporal para valida el correcto funcionamiento y que mis compañero lo pueden editar
        System.out.println("=== Funcionamiento de repuestos e inventario  ===   \n");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        /// crear obgetos inventario
        Inventario Inventario = new Inventario();
        inventario.agregarRepuesto(new Repuestos("Guaya de freno  ", 15000, 10));
        inventario.agregarRepuesto(new Repuestos("Bujía", 8000, 20));
        Usuario usuario = null;

        ///llamarlos metodos para revisar la lista
        inventario.listarRepuestos();

        System.out.println("\nBuscando 'Bujía'...");
        Repuestos encontrado = inventario.buscarPorNombre("Bujía");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado); ///encontro el objeto buscado antes con el metodo   inventario.buscarPorNombre
            if (tipoUsuario == 1) {
                usuario = new Mecanico("Mecánico", "mecanico@taller.com", "Taller Central");
                System.out.println("\n Has iniciado sesión como MECÁNICO\n");
            } else if (tipoUsuario == 2) {
                usuario = new Proveedor("Proveedor", "proveedor@distribuidora.com", "Local Principal");
                System.out.println("\n Has iniciado sesión como PROVEEDOR\n");
            } else {
                System.out.println("No se encontró el repuesto.");  ///lo que ejecuta el null cunado no encuentra nada
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
                            Repuestos Encontrado = inventario.buscarPorNombre(nombreBuscar);
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
    }}