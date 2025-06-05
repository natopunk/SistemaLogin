package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatosSesion {
    private final String archivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();

    public DatosSesion(String usuario) {
        this.archivo = usuario + "_todo.txt";
        crearArchivoSiNoExiste();
        cargarTareas();
    }

    private void crearArchivoSiNoExiste() {
        File f = new File(archivo);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear archivo: " + e.getMessage());
            }
        }
    }

    private void cargarTareas() {
        try (Scanner lector = new Scanner(new File(archivo))) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (!linea.isEmpty()) {
                    tareas.add(new Tarea(linea));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer tareas: " + e.getMessage());
        }
    }

    public void agregarTarea(String descripcion) {
        Tarea nueva = new Tarea(descripcion);
        tareas.add(nueva);
        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write(descripcion + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar tarea: " + e.getMessage());
        }
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}


