package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatosSesion {
    private final String archivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();
    private final HistorialSesion historialSesion = new HistorialSesion();
    private final Usuario usuario;

    public DatosSesion(Usuario usuario) {
        this.usuario = usuario;
        this.archivo = usuario.getNombre() + "_todo.txt";
        crearArchivoSiNoExiste();
        cargarTareas();
    }

    private void crearArchivoSiNoExiste() {
        File f = new File(archivo);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creando archivo de tareas: " + e.getMessage());
            }
        }
    }

    private void cargarTareas() {
        try (Scanner lector = new Scanner(new File(archivo))) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (!linea.isEmpty() && linea.contains(";")) {
                    String[] partes = linea.split(";");
                    tareas.add(new Tarea(partes[0], Prioridad.valueOf(partes[1])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer tareas: " + e.getMessage());
        }
    }


    public void agregarTarea(String descripcion, String prioridad) {
        Tarea nueva = new Tarea(descripcion, Prioridad.valueOf(prioridad));
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

    public void mostrarHistoria() {
        historialSesion.mostrar();
    }

    public HistorialSesion getHistorialSesion() {
        return historialSesion;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}





