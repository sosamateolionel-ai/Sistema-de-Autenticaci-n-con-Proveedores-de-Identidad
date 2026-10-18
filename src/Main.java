import java.util.ArrayList;
import java.util.List;

void main() {

    List<ProveedorIdentidad> proveedores = new ArrayList<>();
    proveedores.add(new AuthGoogle());
    proveedores.add(new AuthGitHub());
    proveedores.add(new AuthApple());

    String[] tokensValidos = {
            "ya29.a0AfH6SMBx7Q2k",
            "ghp_16C7e42F292c6912",
            "eyJhbGci.eyJzdWIi.SflKxwRJ"
    };

    System.out.println("===== Tokens válidos =====");
    for (int i = 0; i < proveedores.size(); i++) {
        proveedores.get(i).autenticar(tokensValidos[i]);
    }

    System.out.println("\n===== Tokens con formato incorrecto =====");
    for (ProveedorIdentidad p : proveedores) {
        p.autenticar("token-cualquiera");
    }

    System.out.println("\n===== Tokens vacíos o nulos =====");
    for (ProveedorIdentidad p : proveedores) {
        p.autenticar("   ");
    }
    proveedores.get(0).autenticar(null);

}
