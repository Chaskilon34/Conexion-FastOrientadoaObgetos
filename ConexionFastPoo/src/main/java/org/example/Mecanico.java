package org.example;

public class Mecanico extends Usuario {
    private String taller;

    public Mecanico(String nombre, String correo, String taller) {
        super(nombre, correo);
        this.taller = taller;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }


    /// 5 metodos abstracos ya declarados nuevos
    @Override
    public void realizarAccionPrincipal(){
        System.out.println("busca un repuesto");
    }

    @Override
    public String getRol(){
        return "Mecánico";
    }

    @Override
    public double calcularBeneficio(){
        return 3.0;
    }

    @Override
    public boolean tienePermisoEspecial() {
        return false;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("==========================================");
        System.out.println("          PANEL DE MECÁNICO              ");
        System.out.println("==========================================");
        System.out.println("Mecánico: " + getNombre() + " | Taller: " + taller);
        System.out.println("Correo: " + getCorreo());
        System.out.println("1. Buscar repuestos en catálogo");
        System.out.println("2. Ver disponibilidad de proveedores");
        System.out.println("3. Crear orden de compra");
        System.out.println("0. Salir");
    }
}