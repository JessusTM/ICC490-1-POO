package Modelo;

import java.io.*;

public class DatosSesion {
    private final Usuario usuario;
    private final HistorialSesion historial;
    private final String archivo;

    public DatosSesion(Usuario usuario) {
        this.usuario = usuario;
        this.archivo = usuario.getNombre() + "_todo.txt";
        this.historial = new HistorialSesion();
        cargarTareas();
    }

    private boolean crearArchivoSiNoExiste(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear archivo de tareas: " + archivo);
                return false;
            }
        }
        return true;
    }

    private void cargarTareas() {
        File file = new File(archivo);
        if (!crearArchivoSiNoExiste(file)) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";", 2);
                if (partes.length == 2) {
                    String descripcion = partes[0];
                    Prioridad prioridad = Prioridad.valueOf(partes[1]);
                    usuario.agregarTarea(new Tarea(descripcion, prioridad, false));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer tareas del archivo: " + archivo);
        }
    }

    public void agregarTarea(Tarea tarea) {
        usuario.agregarTarea(tarea);
        historial.registrarTarea();
        guardarTareaEnArchivo(tarea);
    }

    private void guardarTareaEnArchivo(Tarea tarea) {
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(tarea.getDescripcion() + ";" + tarea.getPrioridad() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar tarea en archivo: " + archivo);
        }
    }

    public HistorialSesion getHistorial() {
        return historial;
    }
}
