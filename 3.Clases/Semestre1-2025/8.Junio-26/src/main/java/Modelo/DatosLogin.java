package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatosLogin {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static final String ARCHIVO = "login.txt";

    public DatosLogin() {
        cargarUsuariosDesdeArchivo();
    }

    private void cargarUsuariosDesdeArchivo() {
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo de login.");
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 3) {
                    String nombre = partes[0];
                    String clave = partes[1];
                    boolean esAdmin = partes[2].equals("1");
                    usuarios.add(new Usuario(nombre, clave, esAdmin));
                } else if (partes.length == 2) {
                    usuarios.add(new Usuario(partes[0], partes[1], false));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de login: " + e.getMessage());
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
