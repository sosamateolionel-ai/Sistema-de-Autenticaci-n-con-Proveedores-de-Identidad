public class AuthGitHub extends ProveedorIdentidad {

    public AuthGitHub() {
        super("GitHub");
    }

    @Override
    protected boolean validarToken(String tokenAcceso) {

        System.out.println("[GitHub] Consultando la API de GitHub (GET /user)...");

        // Regla simulada: los tokens de GitHub empiezan con "ghp_" y tienen exactamente 20 caracteres
        if (!tokenAcceso.startsWith("ghp_") || tokenAcceso.length() != 20) {
            System.out.println("[GitHub] Respuesta 401: credenciales incorrectas.");
            return false;
        }

        return true;
    }
}