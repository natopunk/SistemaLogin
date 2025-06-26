package Modelo;

import java.time.LocalDateTime;

public class HistorialSesion {
    private final LocalDateTime inicio;
    private int tareasAgregadas;

    public HistorialSesion() {
        this.inicio = LocalDateTime.now();
        this.tareasAgregadas = 0;
    }

    public void registrarNuevaTarea() {
        tareasAgregadas++;
    }

    public int getTareasAgregadas() {
        return tareasAgregadas;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }
    public void mostrar() {
        System.out.println("Inicio de sesión: " + inicio);
        System.out.println("Tareas agregadas: " + tareasAgregadas);
    }
}

