package Modelo;

import java.time.LocalDateTime;

public class HistorialSesion {
    private final LocalDateTime inicioSesion;
    private int tareasAgregadas;

    public HistorialSesion() {
        this.inicioSesion = LocalDateTime.now();
        this.tareasAgregadas = 0;
    }

    public void registrarTarea() {
        tareasAgregadas++;
    }

    public LocalDateTime getInicioSesion() {
        return inicioSesion;
    }

    public int getTareasAgregadas() {
        return tareasAgregadas;
    }
}
