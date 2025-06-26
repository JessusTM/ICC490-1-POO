package Modelo;

import java.time.LocalDateTime;

public class Perfil {
  private final String correo;
  private final LocalDateTime fechaCreacion;

  private int tareasBaja;
  private int tareasMedia;
  private int tareasAlta;

  public Perfil(String correo) {
    this.correo = correo;
    this.fechaCreacion = LocalDateTime.now();
    this.tareasBaja = 0;
    this.tareasMedia = 0;
    this.tareasAlta = 0;
  }

  public void registrarTarea(Prioridad prioridad) {
    switch (prioridad) {
      case BAJA -> tareasBaja++;
      case MEDIA -> tareasMedia++;
      case ALTA -> tareasAlta++;
    }
  }

  public int getTareasBaja() {
    return tareasBaja;
  }

  public int getTareasMedia() {
    return tareasMedia;
  }

  public int getTareasAlta() {
    return tareasAlta;
  }

  public String getCorreo() {
    return correo;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  @Override
  public String toString() {
    return " -------- Perfil --------\n" +
            "  Correo          : " + correo + "\n" +
            "  Fecha Creación  : " + fechaCreacion + "\n" +
            "  Tareas por Prioridad:\n" +
            "    BAJA  : " + tareasBaja + "\n" +
            "    MEDIA : " + tareasMedia + "\n" +
            "    ALTA  : " + tareasAlta;
  }
}
