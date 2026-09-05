public class Proveedor extends Usuario {
    private String nombreLocal;

    // Constructor que invoca al padre mediante super()
    public Proveedor(String nombre, String correo, String nombreLocal) {
        super(nombre, correo);
        this.nombreLocal = nombreLocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    // Polimorfismo: Sobreescritura del menú específico para proveedores
    @Override
    public void mostrarMenu() {
        System.out.println("==========================================");
        System.out.println("          PANEL DE PROVEEDOR              ");
        System.out.println("==========================================");
        System.out.println("Proveedor: " + getNombre() + " | Local: " + nombreLocal);
        System.out.println("1. Publicar nuevo repuesto");
        System.out.println("2. Actualizar inventario / precios");
        System.out.println("3. Ver pedidos recibidos de talleres");
        System.out.println("0. Salir");
    }
}