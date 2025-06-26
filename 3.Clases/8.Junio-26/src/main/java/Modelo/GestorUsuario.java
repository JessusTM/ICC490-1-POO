package Modelo;

import java.io.FileWriter;
import java.io.IOException;

public class GestorUsuario {
    private static final String ARCHIVO = "login.txt";

    public GestorUsuario() {}

    public boolean registrarUsuario(String nombre, String clave, boolean esAdmin) {
        try (FileWriter fw = new FileWriter(ARCHIVO, true)) {
            fw.write(nombre + ";" + clave + ";" + (esAdmin ? "1" : "0") + "\n");
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}