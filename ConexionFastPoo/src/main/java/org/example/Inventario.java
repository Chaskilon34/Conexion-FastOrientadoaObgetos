package org.example;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Repuestos> listaRepuestos;
///creanis la lista
    public Inventario() {
        this.listaRepuestos = new ArrayList<>();
    }
/// metodo para agregar repuesto
    public void agregarRepuesto(Repuestos repuesto) {
        listaRepuestos.add(repuesto);
        System.out.println("Repuesto agregado: " + repuesto.getNombre());
    }
/// ver lista de repuestos isEmpty es un metodo interno del arraylist valida si la lista esta vacia o llena para votar el texto de no hay repuesto registrados
    public void listarRepuestos() {
        if (listaRepuestos.isEmpty()) {
            System.out.println("No hay repuestos registrados.");
        } else {
            System.out.println("_______Lista de repuestos_______");
            for (Repuestos repuesto : listaRepuestos) {
                System.out.println(repuesto);
            }
        }
    }
/// buscar dentro de la lista el repuesto en base al nombre los compara
    public Repuestos buscarPorNombre(String nombre) {
        for (Repuestos repuestoB : listaRepuestos) {
            if (repuestoB.getNombre().equalsIgnoreCase(nombre)) {
                return repuestoB;
            }
        }
        /// Si el for termina sin encontrar coincidencias con equalsIgnoreCase, se indica que el objeto no existe
        return null;
    }
}
