package Modelo;

import java.util.ArrayList;

public class DatosLogin {
    public ArrayList<Usuario> usuarios = new ArrayList<>();

    public DatosLogin() {
        usuarios.add(new Usuario("admin", "admin123"));
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}

