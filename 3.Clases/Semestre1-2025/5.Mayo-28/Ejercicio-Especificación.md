# Sistema de Login con Tareas Personales

Usando el ejercicio desarrollado el [21 de mayo](../4.Mayo-21/Ejercicio-Especificación.md) como base, desarrollar una versión ampliada que incluya la lectura de datos para generar una lista TO-DO.

### Objetivos

* Simular un sistema de inicio de sesión con múltiples usuarios.
* Mantener una sesión activa por usuario autenticado.
* Permitir a los usuarios escribir tareas personales tipo «to-do list», almacenadas en un archivo propio.
* Restringir la opción de registrar nuevos usuarios únicamente al usuario especial llamado `admin`.
* Aplicar el principio de responsabilidad única (Single Responsibility Principle).
* Verificar la existencia de archivos necesarios y crearlos si no existen.
* Organizar el sistema en paquetes que representen la arquitectura Modelo-Vista-Controlador.

---
### Estructura

```plaintext
SistemaLogin/
├── Launcher/
│   └── Inicio.java                     ← Punto de entrada del programa
│
├── Modelo/
│   ├── DatosLogin.java                 ← Maneja credenciales desde login.txt
│   ├── DatosSesion.java                ← Maneja archivos de tareas personales
│   └── GestorUsuarios.java             ← Registro de nuevos usuarios
│
├── Vista/
│   └── ConsolaLogin.java               ← Interfaz por consola (menú principal)
│
├── Controlador/
│   ├── Login.java                      ← Lógica de autenticación
│   └── SesionActiva.java               ← Gestión de usuarios logueados
│
├── login.txt                           ← Archivo de credenciales
├── admin_todo.txt                      ← Archivo de tareas del usuario admin
├── usuario1_todo.txt                   ← Archivo de tareas por cada usuario
```

---
### Descripción de clases

##### 1. Inicio

* Contiene el método `main`.
* Inicia el sistema creando una instancia de `ConsolaLogin` y llamando al método `menu()`.

##### 2. ConsolaLogin

* Muestra el menú principal del sistema.
* Solicita usuario y contraseña.
* Llama a `Login` para autenticar.
* Si la autenticación es exitosa, inicia `SesionActiva`.

##### 3. Login

* Recibe usuario y contraseña.
* Verifica las credenciales consultando los datos proporcionados por `DatosLogin`.

##### 4. DatosLogin

* Lee y carga las credenciales desde el archivo `login.txt`.
* Si el archivo no existe, lo crea automáticamente vacío.
* Almacena los pares `usuario;contraseña` en una estructura interna para consulta.

##### 5. SesionActiva

* Representa el ciclo de interacción del usuario logueado.
* Crea y utiliza una instancia de `DatosSesion` para manipular las tareas.
* Si el usuario es `admin`, permite registrar nuevos usuarios con `GestorUsuarios`.

##### 6. DatosSesion

* Gestiona el archivo de tareas personales (`<usuario>_todo.txt`).
* Si no existe, lo crea automáticamente.
* Permite escribir nuevas tareas y mostrarlas por consola.

##### 7. GestorUsuarios

* Permite al usuario `admin` registrar nuevos usuarios.
* Agrega nuevas líneas al archivo `login.txt`.
* Crea el archivo si no existe.

--- 
### Código Base 

##### Launcher/Inicio.java

```java
package Launcher;

import vista.ConsolaLogin;

/**
 * Clase principal del sistema.
 * Contiene el método main para lanzar la aplicación.
 */
public class Inicio {
    public static void main(String[] args) {
        ConsolaLogin consola = new ConsolaLogin();
        consola.menu();
    }
}
```

##### Vista/ConsolaLogin.java

```java
package Vista;

import controlador.Login;
import controlador.SesionActiva;
import modelo.DatosLogin;

import java.util.Scanner;

/**
 * Vista principal del sistema.
 * Interactúa con el usuario mediante consola.
 */
public class ConsolaLogin {
    private final Scanner scanner = new Scanner(System.in);
    private final DatosLogin datos = new DatosLogin();
    private final Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() {
        // TODO: Mostrar opciones en un bucle con switch.
        // TODO: Permitir iniciar sesión o salir del sistema.
    }

    /**
     * Solicita usuario y contraseña y maneja la autenticación.
     */
    private void manejarLogin() {
        // TODO: Pedir usuario y contraseña.
        // TODO: Llamar a login.autenticar().
        // TODO: Si es correcto, iniciar SesionActiva.
    }

    /**
     * Muestra el menú principal.
     */
    private void mostrarOpciones() {
        // TODO: Imprimir menú "1. Iniciar sesión", "2. Salir".
    }
}
```

##### Controlador/Login.java

```java
package Controlador;

import modelo.DatosLogin;

/**
 * Clase encargada de la lógica de autenticación.
 */
public class Login {

    /**
     * Verifica si las credenciales son válidas.
     *
     * @param usuario nombre ingresado
     * @param clave contraseña ingresada
     * @param datos instancia de DatosLogin
     * @return true si son válidas, false si no
     */
    public boolean autenticar(String usuario, String clave, DatosLogin datos) {
        // TODO: Buscar la línea "usuario;clave" en datos.getCredenciales().
        return false;
    }
}
```

##### Controlador/SesionActiva.java

```java
package Controlador;

import modelo.DatosSesion;
import modelo.GestorUsuarios;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final String usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;

    public SesionActiva(String usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario);
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        // TODO: Mostrar opciones según si el usuario es admin o no.
        // TODO: Escribir tareas.
        // TODO: Registrar usuarios (solo admin).
        // TODO: Salir de sesión.
    }

    private void escribirTarea() {
        // TODO: Pedir tarea al usuario y delegar a datosSesion.
    }

    private void registrarUsuario() {
        // TODO: Usar GestorUsuarios para registrar un nuevo usuario.
    }
}
```

##### Modelo/DatosLogin.java

```java
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestiona el archivo login.txt.
 */
public class DatosLogin {
    private final String archivo = "login.txt";
    private final ArrayList<String> credenciales = new ArrayList<>();

    public DatosLogin() {
        crearArchivoSiNoExiste();
        cargarUsuarios();
    }

    /**
     * Devuelve la lista de credenciales cargadas.
     */
    public ArrayList<String> getCredenciales() {
        return credenciales;
    }

    /**
     * Crea el archivo login.txt si no existe.
     */
    private void crearArchivoSiNoExiste() {
        // TODO: Verificar existencia del archivo y crearlo si no existe.
    }

    /**
     * Carga los pares usuario;clave desde el archivo a la lista.
     */
    private void cargarUsuarios() {
        // TODO: Leer línea por línea y agregar solo las válidas al ArrayList.
    }
}
```


##### Modelo/DatosSesion.java

```java
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Maneja las tareas personales de un usuario autenticado.
 */
public class DatosSesion {
    private final String nombreArchivo;

    public DatosSesion(String usuario) {
        this.nombreArchivo = usuario + "_todo.txt";
        crearArchivoSiNoExiste();
    }

    /**
     * Crea el archivo de tareas si no existe.
     */
    private void crearArchivoSiNoExiste() {
        // TODO: Verificar existencia del archivo y crearlo si no existe.
    }

    /**
     * Escribe una nueva tarea al final del archivo.
     *
     * @param tarea Texto de la tarea.
     * @return true si se guardó correctamente, false si ocurrió un error.
     */
    public boolean escribirTarea(String tarea) {
        // TODO: Implementar escritura en el archivo.
        return false;
    }

    /**
     * Muestra todas las tareas almacenadas en el archivo.
     */
    public void mostrarTareas() {
        // TODO: Leer y mostrar cada línea del archivo.
    }
}
```

##### Modelo/GestorUsuarios.java

```java
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Registra nuevos usuarios en login.txt.
 */
public class GestorUsuarios {
    private final String archivo = "login.txt";

    public GestorUsuarios() {
        // TODO: Crear archivo si no existe.
    }

    public boolean registrar(String usuario, String clave) {
        // TODO: Agregar usuario al archivo login.txt.
        return false;
    }
}
```
