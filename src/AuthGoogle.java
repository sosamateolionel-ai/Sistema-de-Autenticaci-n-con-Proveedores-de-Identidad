public class AuthGoogle extends ProveedorIdentidad {

    public AuthGoogle() {
        super("Google");
    }

    @Override
    protected boolean validarToken(String tokenAcceso) {

        System.out.println("[Google] Consultando el endpoint de verificación de tokens de Google...");

        // Regla simulada: los tokens de Google empiezan con "ya29." y tienen al menos 15 caracteres
        if (!tokenAcceso.startsWith("ya29.") || tokenAcceso.length() < 15) {
            System.out.println("[Google] El token no tiene un formato válido o expiró.");
            return false;
        }

        return true;
    }
}