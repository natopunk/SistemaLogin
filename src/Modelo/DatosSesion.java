package Modelo;

import java.util.ArrayList;

public class DatosSesion {
    public ArrayList<Tarea> tareas = new ArrayList<>();

    public DatosSesion(String usuario) {
        tareas.add(new Tarea("Tarea de ejemplo"));
    }
}

