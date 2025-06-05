package Controlador;

import Modelo.DatosLogin;
import Modelo.Usuario;

public class Login {
    public Usuario autenticar(String usuario, String clave, DatosLogin datos) {
        for (Usuario u : datos.getUsuarios()) {
            if (u.nombre.equals(usuario) && u.clave.equals(clave)) {
                return u;
            }
        }
        return null;
    }
}
