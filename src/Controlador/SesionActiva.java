package Controlador;

import Modelo.Usuario;
import Modelo.DatosSesion;
import Modelo.GestorUsuarios;

import java.util.Scanner;

public class SesionActiva {
    private final Usuario usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final GestorUsuarios gestorUsuarios = new GestorUsuarios();

    public SesionActiva(Usuario usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario);
    }

    public void menuSesion() {
        String opcion;
        do {
            System.out.println("\n-- MENÚ DE USUARIO: " + usuario.getNombre() + " --");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            if (usuario.getNombre().equals("admin")) {
                System.out.println("3. Registrar usuario");
            }
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> mostrarTareas();
                case "2" -> escribirTarea();
                case "3" -> {
                    if (usuario.getNombre().equals("admin")) registrarUsuario();
                    else System.out.println("No autorizado.");
                }
            }
        } while (!opcion.equals("4"));
        datosSesion.mostrarHistoria();
    }

    private void mostrarTareas() {
        System.out.println("\n-- TUS TAREAS --");
        datosSesion.getTareas().forEach(t ->
                System.out.println("-[" + t.getPrioridad() + "] " + t.getDescripcion())
        );
    }

    private void escribirTarea() {
        System.out.print("Escribe la nueva tarea: ");
        String tarea = scanner.nextLine();
        System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
        String nivel = scanner.nextLine().toUpperCase();
        datosSesion.agregarTarea(tarea, nivel);
    }

    private void registrarUsuario() {
        System.out.print("Nuevo usuario: ");
        String nuevo = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();
        boolean resultado = gestorUsuarios.registrar(nuevo, clave, correo);
        if (resultado) System.out.println("Usuario registrado correctamente.");
        else System.out.println("Error al registrar usuario.");
    }
}


