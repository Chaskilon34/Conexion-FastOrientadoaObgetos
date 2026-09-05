public abstract class Usuario {
    private String nombre;
    private String correo;

    // Constructor base
    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters y Setters
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

    // Método abstracto: Abstracción (define QUÉ hace cada usuario, no CÓMO)
    public abstract void mostrarMenu();
}