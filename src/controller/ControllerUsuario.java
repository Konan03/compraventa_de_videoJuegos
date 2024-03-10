package controller;

import model.Usuario;
import model.VideoJuego;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) throws RuntimeException {
        if (usuario != null) {
            if (usuario.validarUsuario()) {
                if (!existeId(usuario.getId())) {
                    usuarios.add(usuario);
                    System.out.println("Videojuego agregado correctamente.");
                } else {
                    throw new RuntimeException("Error: Ya existe un usuario con ese ID.");
                }
            } else {
                throw new RuntimeException("Error: Campos inválidos para el usuario.");
            }
        } else {
            throw new RuntimeException("Error: usuario nulo.");
        }
    }
    private static boolean existeId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static List<Usuario> listarUsuarios(){
        return usuarios;
    }

    public static void eliminarVideoJuego(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                System.out.println("Videojuego eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún videojuego con ese ID.");
    }

    public static void eliminarVideoJuego(String nombre) {
        usuarios.removeIf(usuario -> nombre.equalsIgnoreCase(usuario.getNombre()));
    }

    public static Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public static Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

}