## Login con Swing

Para esta semana se seguirá con el enfoque iterativo de mejorar el sistema de Login, pero, en este caso enfocado transformar la vista de consola a una interfaz gráfica utilizando Java Swing, de manera que el usuario interactúe con una ventana gráfica.

Este cambio de consola a ventana deberá afectar únicamente al package de Vista, es decir, no se deben modificar las clases del Modelo ni del Controlador. La lógica ya implementada debe ser reutilizada tal como está. 

> En caso de estar atrasado en el código del sistema, recurrir al siguiente [link](./src/), el cual contendrá un directorio con los códigos del package Modelo y Controlador.

---
### **Requisitos funcionales**

1. Clase LoginView
   * Campos: Usuario y Contraseña.
   * Botón: Iniciar Sesión.
   * Si las credenciales son válidas, se debe abrir una segunda ventana con las tareas del usuario.
   * Si las credenciales no son válidas, se debe mostrar un mensaje de error con `JOptionPane`.

2. Clase MainView
   * Lista con todas las tareas del usuario autenticado.
   * Cada tarea debe indicar su prioridad y estado (activa o finalizada).
   * Campo de búsqueda que filtre tareas por descripción.
   * Botón «Agregar tarea» que abra un formulario emergente para ingresar la descripción y prioridad.
   * Las tareas deben poder marcarse como finalizadas desde la interfaz.

---
### **Restricciones**

* **NO** se deben modificar las clases del paquete Modelo ni Controlador.
* **NO** se debe escribir lógica compleja en las ventanas, deben limitarse a mostrar datos y llamar métodos existentes del sistema.

