package Vista;

import Controlador.Login;
import Controlador.SesionActiva;
import Modelo.DatosLogin;
import Modelo.Usuario;

import java.util.Scanner;

public class ConsolaLogin {
    private final Scanner scanner = new Scanner(System.in);
    private final DatosLogin datos = new DatosLogin();
    private final Login login = new Login();

    public void menu() {
        System.out.println("\n=== BIENVENIDO AL SISTEMA ===");
        manejarLogin();
    }

    private void manejarLogin() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String clave = scanner.nextLine();

        Usuario autenticado = login.autenticar(usuario, clave, datos);
        if (autenticado != null) {
            SesionActiva sesion = new SesionActiva(autenticado);
            sesion.menuSesion();
        } else {
            System.out.println("Credenciales inválidas.\n");
            menu();
        }
    }
}


