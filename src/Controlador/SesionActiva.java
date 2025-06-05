package Controlador;

import Modelo.Usuario;

public class SesionActiva {
    private final Usuario usuario;

    public SesionActiva(Usuario usuario) {
        this.usuario = usuario;
    }

    public void menuSesion() {
        System.out.println("Bienvenido " + usuario.nombre);
    }
}

