package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String nombre;
    private String clave;
    private Perfil perfil;
    private List<Tarea> tareas;

    public Usuario(String nombre, String clave, String correo) {
        this.nombre = nombre;
        this.clave = clave;
        this.perfil = new Perfil(correo);
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea tarea) {
        tarea.add(tarea);
    }
}


