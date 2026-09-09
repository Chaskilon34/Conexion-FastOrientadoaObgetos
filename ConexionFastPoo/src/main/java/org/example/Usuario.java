package org.example;

public abstract class Usuario {
    private String nombre;
    private String correo;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /// aca  Se agregan 4 metodos abstracto + el ya creado

    public abstract void mostrarMenu();
    public abstract void realizarAccionPrincipal();
    public abstract String getRol();
    public abstract double calcularBeneficio();
    public abstract boolean tienePermisoEspecial();
}