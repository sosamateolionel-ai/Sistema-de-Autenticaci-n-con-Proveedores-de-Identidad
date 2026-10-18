public abstract class ProveedorIdentidad {

    protected String nombreProveedor;

    public ProveedorIdentidad(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    // Punto de entrada: rechaza tokens vacíos o nulos y luego delega
    public boolean autenticar(String tokenAcceso) {

        System.out.println("\n>>> Autenticando con " + nombreProveedor);

        if (tokenAcceso == null || tokenAcceso.trim().isEmpty()) {
            System.out.println("[" + nombreProveedor + "] Error: el token está vacío o es nulo, no se contacta a la API.");
            return false;
        }

        boolean valido = validarToken(tokenAcceso);

        if (valido) {
            System.out.println("[" + nombreProveedor + "] Acceso concedido.");
        } else {
            System.out.println("[" + nombreProveedor + "] Acceso denegado.");
        }

        return valido;
    }

    // Cada proveedor define cómo verifica el token contra su API
    protected abstract boolean validarToken(String tokenAcceso);
}