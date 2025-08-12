# Sistema de Login con Tareas Personales — Semana 2 (POO, asociaciones e historial)

Tomando como base la versión desarrollada la [clase anterior](../6.Junio-05/Ejercicio-Especificación.md), se extenderá la solución de tal manera que incorpore los siguiente:

--- 
### Requerimientos Técnicos (OBLIGATORIOS)

* Mantener el uso de constructores, encapsulamiento y división por paquetes siguiendo el patrón arquitectónico MVC.
* Incorporar una relación de asociación 1:1 entre «Usuario» y una nueva clase «Perfil», que almacene información del usuario: Correo, fecha de creación y cantidad de tareas por prioridad.
* Incorporar una relación de asociación 1:N entre «Usuario» y «Tarea» (cada usuario tiene una lista de tareas).
* Las tareas deben seguir mostrando su descripción, pero ahora también deben tener una prioridad definida mediante un Enum (BAJA, MEDIA, ALTA).
* Incluir una clase «HistorialSesion», asociada a la clase «DatosSesion», de manera que al momento de salir del programa muestre:
  - Fecha y hora de inicio de sesión.
  - Cantidad de tareas agregadas en esa sesión.
* Permitir al usuario marcar tareas como finalizadas al momento de listarlas. Las tareas se mostrarán clasificadas como activas o finalizadas.

--- 
### Preguntas 
1. Si adicionalmente, se desea agregar distintos tipos de tarea, como tareas con limite. ¿Qué tipo de mecanismo facilitaría esta extensión sin alterar el comportamiento actual del sistema?

2. Si consideramos que HistorialSesion es una clase que puede existir independientemente, pero que es usada por la clase DatosSesion para registrar eventos de la sesión. ¿Qué tipo de relación existe entre estas dos clases? 

3. Desde una perspectiva del principio de responsabilidad única, ¿por qué es beneficioso delegar el registro del historial de tareas a una clase separada (HistorialSesion) en lugar de manejarlo directamente dentro de DatosSesion?

4. Actualmente en el sistema cada usuario mantiene una colección de tareas. ¿Qué importancia tiene esta decisión desde la perspectiva de la responsabilidad de clases y el control del ciclo de vida de los objetos?

--- 
### Cambios en las clases

##### [MODIFICACIÓN] Usuario
  - Atributos:
    - «Perfil perfil».

##### [MODIFICACIÓN] Tarea 
  - Atributos:
    - boolean finalizada

  - Métodos:
    - boolean estaFinalizada
    - void marcarFinalizada

##### [NUEVO] Perfil
  - Atributos:
    - String correo
    - LocalDateTime fechaCreacion

##### [NUEVO] Prioridad
  - Clase Enum 
    - BAJA
    - MEDIA
    - ALTA

##### [NUEVO] HistorialSesion
  - Atributos:
    - LocalDateTime inicio
    - int tareasAgregadas

  - Métodos:
    - registrarNuevaTarea
    - getTareasAgregadas
    - getInicio

##### [MODIFICACIÓN] DatosSesion
  - Atributos: 
    - «HistorialSesion historial».

  - Métodos:
    - registrarNuevaTarea (cada vez que se agrega una tarea)
    - ArrayList<Tarea> getTareasActivas()
    - ArrayList<Tarea> getTareasFinalizadas()
    - boolean finalizarTarea(int indice)

--- 
### Estructura Actualizada

```plaintext
SistemaLogin/
├── Launcher/
│   └── Inicio.java
│
├── Modelo/
│   ├── Usuario.java
│   ├── Perfil.java 
│   ├── Tarea.java
│   ├── Prioridad.java
│   ├── HistorialSesion.java 
│   ├── DatosLogin.java
│   ├── DatosSesion.java
│   └── GestorUsuarios.java
│
├── Vista/
│   └── ConsolaLogin.java
│
├── Controlador/
│   ├── Login.java
│   └── SesionActiva.java
│
├── login.txt
├── admin_todo.txt
├── usuario1_todo.txt
```

