package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestorUsuarios {
    private final String archivo = "login.txt";

    public GestorUsuarios() {
        File f = new File(archivo);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creando login.txt: " + e.getMessage());
            }
        }
    }

    public boolean registrar(String nombre, String clave) {
        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write(nombre + ";" + clave + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
}
