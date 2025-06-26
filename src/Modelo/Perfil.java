package Modelo;

import java.time.LocalDateTime;

public class Perfil {
    private final String correo;
    private final LocalDateTime fechaCreacion;

    public Perfil(String correo) {
        this.correo = correo;
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}

