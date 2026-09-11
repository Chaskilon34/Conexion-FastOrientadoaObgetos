package org.example;

public class Administrador extends Usuario {
    private String nivelAcceso;

    private int publicacionesRevisadas; /// Nuevo atributo acomulador


    public Administrador(String nombre, String correo, String nivelAcceso) {
        super(nombre, correo);
        this.nivelAcceso = nivelAcceso;

        this.publicacionesRevisadas = 0; /// empieza en 0

    }
    public String getNivelAcesso() {
        return nivelAcceso;
    }
    public void setNivelAcesso(String nivelAcesso) {
            this.nivelAcceso = nivelAcesso;
    }


    public int getPublicacionesRevisadas() {
        return publicacionesRevisadas;
    }

    public void resasarPublicacion() {
        publicacionesRevisadas++;
        System.out.println("Publicacion revisada. Total: " + publicacionesRevisadas);
    }



    /// Implementación de los 5 Métodos Abstractos, Como Usuario.java definió 5 métodos con abstract
    @Override
    public void realizarAccionPrincipal() {
        System.out.println(getNombre() + " está supervisando los permisos del sistema. ");
    }

    @Override
    public String getRol() {
        return "Administrador";
    }

    @Override
    public double calcularBeneficio() {

        return 25000.0;


    }

    @Override
    public boolean tienePermisoEspecial() {
        return true;
    }

    @Override
    public void mostrarMenu () {
        System.out.println("==========================================");
        System.out.println("         PANEL DE ADMINISTRADOR           ");
        System.out.println("==========================================");
        System.out.println("Admin: " + getNombre() + " | Nivel: " + nivelAcceso);
        System.out.println("Correo: " + getCorreo());
        System.out.println("1. Gestionar usuarios y roles");
        System.out.println("2. Revisar reportes globales");
        System.out.println("3. Configuración del sistema");
        System.out.println("0. Salir");
    }
}

