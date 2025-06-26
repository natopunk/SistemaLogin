package Modelo;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;
    private boolean completada;

    public Tarea(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }

    public Tarea(String descripcion, Prioridad prioridad, boolean completada){
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void add(Tarea tarea) {
    }
}


