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
        manejarLogin();
    }

    private void manejarLogin() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();
        Usuario u = login.autenticar(usuario, clave, datos);
        if (u != null) {
            new SesionActiva(u).menuSesion();
        } else {
            System.out.println("Error de autenticación.");
        }
    }
}

