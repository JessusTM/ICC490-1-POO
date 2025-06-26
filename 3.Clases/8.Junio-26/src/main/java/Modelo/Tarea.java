package Modelo;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;
    private boolean finalizada;

    public Tarea(String descripcion, Prioridad prioridad, boolean finalizada) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.finalizada = finalizada;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public boolean estaFinalizada() {
        return finalizada;
    }

    public void marcarFinalizada() {
        this.finalizada = true;
    }
}
