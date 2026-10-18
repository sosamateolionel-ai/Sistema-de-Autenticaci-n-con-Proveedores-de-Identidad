public class AuthApple extends ProveedorIdentidad {

    public AuthApple() {
        super("Apple");
    }

    @Override
    protected boolean validarToken(String tokenAcceso) {

        System.out.println("[Apple] Verificando la firma del token de identidad (JWT)...");

        // Regla simulada: un JWT tiene tres partes separadas por puntos
        if (tokenAcceso.split("\\.").length != 3) {
            System.out.println("[Apple] El token no tiene la estructura de un JWT (encabezado.contenido.firma).");
            return false;
        }

        return true;
    }
}