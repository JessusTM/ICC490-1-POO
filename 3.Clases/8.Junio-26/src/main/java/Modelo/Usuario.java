package Modelo;

import java.util.ArrayList;

public class Usuario {
    private final String nombre;
    private String clave;
    private boolean esAdmin;
    private final ArrayList<Tarea> tareas;
    private final Perfil perfil;

    public Usuario(String nombre, String clave, boolean esAdmin) {
        this.nombre = nombre;
        this.clave = clave;
        this.esAdmin = esAdmin;
        this.tareas = new ArrayList<>();
        this.perfil = new Perfil(nombre + "@correo.com");
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public boolean esAdmin() {
        return esAdmin;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
        perfil.registrarTarea(tarea.getPrioridad());
    }

    public ArrayList<Tarea> getTareasActivas() {
        ArrayList<Tarea> activas = new ArrayList<>();
        for (Tarea t : tareas) {
            if (!t.estaFinalizada()) {
                activas.add(t);
            }
        }
        return activas;
    }

    public ArrayList<Tarea> getTareasFinalizadas() {
        ArrayList<Tarea> finalizadas = new ArrayList<>();
        for (Tarea t : tareas) {
            if (t.estaFinalizada()) {
                finalizadas.add(t);
            }
        }
        return finalizadas;
    }

    public boolean finalizarTarea(int indice) {
        ArrayList<Tarea> activas = getTareasActivas();
        if (indice >= 0 && indice < activas.size()) {
            activas.get(indice).marcarFinalizada();
            return true;
        }
        return false;
    }
}
