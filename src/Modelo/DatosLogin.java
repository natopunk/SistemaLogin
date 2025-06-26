package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DatosLogin {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();

    public DatosLogin() {
        File archivo = new File("login.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear login.txt: " + e.getMessage());
            }
        }
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        try (Scanner lector = new Scanner(new File("login.txt"))) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (linea.contains(";")) {
                    String[] partes = linea.split(";");
                    if (partes.length == 3) {
                        usuarios.add(new Usuario(partes[0], partes[1], partes[2]));
                    } else {
                        System.out.println("Línea mal formada: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer login.txt: " + e.getMessage());
        }
    }


    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}


