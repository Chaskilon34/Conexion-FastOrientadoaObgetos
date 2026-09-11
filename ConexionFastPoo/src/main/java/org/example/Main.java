package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Arreglo de tipo Usuario (Clase Abstracta) para demostrar Polimorfismo
        Usuario[] usuarios = new Usuario[3];
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
       // poliformismo
       usuarios[0] = new Mecanico("Carlos Pérez", "carlos@taller.com", "Taller El Pits");
       usuarios[1] = new Proveedor("Distribuidora MotoRepuestos", "ventas@motorepuestos.com", "Local Central #4");
       usuarios[2] = new Administrador("Juan David", "admin@conexionparts.com", "Súper Admin");

        System.out.println("=== DEMOSTRACIÓN DE POLIMORFISMO DE USUARIOS ===\n");
        inventario.agregarRepuesto(new Repuestos("Guaya de freno", 15000, 10));
        inventario.agregarRepuesto(new Repuestos("Bujía", 8000, 20));
        inventario.agregarRepuesto(new Repuestos("Filtro de aceite", 12000, 15));
        // bucle de poliformismo
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
        System.out.print("Escribe 'Mecanico' o 'Proveedor': ");

        String tipoTexto = scanner.nextLine();

        // crear obgetos inventario

        inventario.agregarRepuesto(new Repuestos("Guaya de freno  ", 15000, 10));
        inventario.agregarRepuesto(new Repuestos("Bujía", 8000, 20));
        Usuario usuario;

        //llamarlos metodos para revisar la lista
        inventario.listarRepuestos();


        if (tipoTexto.equalsIgnoreCase("Mecanico")) {
            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingresa tu correo: ");
            String correo = scanner.nextLine();
            System.out.print("Ingresa tu taller: ");
            String taller = scanner.nextLine();

            usuario = new Mecanico(nombre, correo, taller);
            System.out.println("\nHas iniciado sesión como MECÁNICO\n");

        } else if (tipoTexto.equalsIgnoreCase("Proveedor")) {
            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingresa tu correo: ");
            String correo = scanner.nextLine();
            System.out.print("Ingresa tu local: ");
            String local = scanner.nextLine();

            usuario = new Proveedor(nombre, correo, local);
            System.out.println("\nHas iniciado sesión como PROVEEDOR\n");

        } else {
            System.out.println("Opción no válida. Saliendo...");
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
                        if (tipoTexto.equalsIgnoreCase("Mecanico")) {

                            System.out.print("Ingresa el nombre del repuesto a buscar: ");
                            String nombreBuscar = scanner.nextLine();
                            Repuestos Encontrado = inventario.buscarPorNombre(nombreBuscar);
                            if (Encontrado != null) {
                                System.out.println("Encontrado: " + Encontrado);
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
                        if (tipoTexto.equalsIgnoreCase("Mecanico")) {

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
                        if (tipoTexto.equalsIgnoreCase("Mecanico")) {

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