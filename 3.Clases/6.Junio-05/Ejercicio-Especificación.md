# Sistema de Login con Tareas Personales — Versión Orientada a Objetos

Tomando como base el ejercicio desarrollado el [28 de Mayo] (../5.Mayo-28/Ejercicio-Especificación.md), se solicita adaptar la solución a una orientada completamente a POO:

* Definición de clases con atributos privados.
* Uso de constructores para inicializar instancias.
* Implementación de métodos getter y setter para controlar el acceso a los datos.
* Aplicación de la responsabilidad única y el diseño modular con separación de paquetes.

Adicionalmente, se solicita agregar dentro del menú TODO, una lista con las tareas.

--- 
### Requerimientos (OBLIGATORIOS)
* Utilizar constructores en las clases para inicializar atributos clave como el nombre de archivo, credenciales o datos de sesión.

* Aplicar encapsulamiento: proteger los atributos y acceder a ellos mediante getters y setters.

* Dividir el sistema en paquetes que representen la arquitectura Modelo-Vista-Controlador (MVC).

--- 
### Estructura 

```plaintext
SistemaLogin/
├── Launcher/
│   └── Inicio.java                   ← Punto de entrada
│
├── Modelo/
│   ├── Usuario.java                  ← Clase que encapsula datos de usuario
│   ├── Tarea.java                    ← Clase que representa una tarea individual
│   ├── DatosLogin.java               ← Manejo de credenciales (ahora como objetos Usuario)
│   ├── DatosSesion.java              ← Manejo de tareas (lista de objetos Tarea)
│   └── GestorUsuarios.java           ← Registro de nuevos usuarios
│
├── Vista/
│   └── ConsolaLogin.java             ← Menú por consola
│
├── Controlador/
│   ├── Login.java                    ← Lógica de autenticación
│   └── SesionActiva.java             ← Ciclo de operaciones por sesión
│
├── login.txt                         ← Archivo con credenciales
├── admin_todo.txt                    ← Tareas del admin
├── usuario1_todo.txt                 ← Tareas del usuario1
```

--- 
### Descripción de Clases 

##### 1. Inicio

* Contiene el método `main`.
* Inicia el sistema creando una instancia de `ConsolaLogin` y llamando al método `menu()`.

##### 2. ConsolaLogin

* Muestra el menú principal del sistema por consola.
* Solicita usuario y contraseña.
* Llama a la clase `Login` para autenticar al usuario.
    * Si la autenticación es exitosa instancia a `SesionActiva` y comienza la interacción.
* Se comunica con los paquetes `Controlador` y `Modelo`.

##### 3. Login

* Recibe el nombre de usuario y la contraseña como entrada.
* Verifica las credenciales buscando una coincidencia en la lista de objetos `Usuario` proporcionada por `DatosLogin`.
* Retorna `true` o `false` según el éxito de la autenticación.

##### 4. DatosLogin

* Se encarga de cargar y administrar los datos de los usuarios desde el archivo `login.txt`.

> Si el archivo no existe, lo crea automáticamente.

* Lee los pares `usuario;contraseña` y los encapsula en instancias de la clase `Usuario`.
* Utiliza una lista interna de objetos `Usuario`, protegida por encapsulamiento.
* Proporciona acceso a esta lista mediante un método getter.

##### 5. SesionActiva

* Representa el ciclo de operaciones disponibles para un usuario autenticado.
* Instancia la clase `DatosSesion`, asociada al usuario autenticado.
* Permite:

  * Agregar tareas personales.
  * Visualizar tareas almacenadas.
  * Registrar nuevos usuarios (solo si el usuario activo es `admin`).
* Interactúa con las clases `Tarea`, `DatosSesion` y `GestorUsuarios`.

##### 6. DatosSesion

* Encapsula la lógica para manipular las tareas personales del usuario autenticado.
* Usa una lista interna de objetos `Tarea` (una clase que representa cada tarea).
* Si el archivo `<usuario>_todo.txt` no existe, lo crea automáticamente.
* Carga las tareas desde el archivo a objetos `Tarea`.
* Permite:

  * Agregar nuevas tareas a la lista y al archivo.
  * Mostrar todas las tareas al usuario.

##### 7. GestorUsuarios

* Permite al usuario especial `admin` registrar nuevos usuarios.
* Verifica la existencia del archivo `login.txt` y lo crea si no existe.
* Agrega nuevos pares `usuario;clave` al archivo.
* No almacena datos en memoria, trabaja directamente sobre el archivo.

##### 8. Usuario (nueva clase)

* Representa un usuario del sistema con atributos privados `nombre` y `clave`.
* Se inicializa mediante un constructor.
* Usa métodos `getNombre()`, `getClave()` y `setClave()` para acceso controlado.
* Utilizada principalmente por `DatosLogin` y `Login`.

##### 9. Tarea (nueva clase)

* Representa una tarea individual con un atributo privado `descripcion`.
* Se inicializa mediante un constructor.
* Usa `getDescripcion()` y `setDescripcion()` para manipular el contenido de la tarea.
* Utilizada por `DatosSesion`.

--- 
### Código Base 

##### Launcher/Inicio.java

```java
package Launcher;

import Vista.ConsolaLogin;

/**
 * Clase principal del sistema.
 */
public class Inicio {
    public static void main(String[] args) {
        // TODO: Crear instancia de ConsolaLogin y llamar a menu()
    }
}
```

##### Vista/ConsolaLogin.java

```java
package Vista;

import Controlador.Login;
import Controlador.SesionActiva;
import Modelo.DatosLogin;
import Modelo.Usuario;

import java.util.Scanner;

/**
 * Vista principal del sistema.
 */
public class ConsolaLogin {
    private final Scanner scanner = new Scanner(System.in);
    private final DatosLogin datos = new DatosLogin();
    private final Login login = new Login();

    /**
     * Muestra el menú principal del sistema.
     */
    public void menu() {
        // TODO: Mostrar mensaje de bienvenida y manejar login
    }

    /**
     * Solicita usuario y clave, autentica, y lanza la sesión si corresponde.
     */
    private void manejarLogin() {
        // TODO: Solicitar usuario y clave, autenticar, y lanzar sesión si procede
    }
}
```

##### Controlador/Login.java

```java
package Controlador;

import Modelo.DatosLogin;
import Modelo.Usuario;

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
     * @return Usuario autenticado si es válido, null si no
     */
    public Usuario autenticar(String usuario, String clave, DatosLogin datos) {
        // TODO: Buscar si existe un objeto Usuario con esas credenciales.
        return null;
    }
}
```

##### Controlador/SesionActiva.java

```java
package Controlador;

import Modelo.Usuario;
import Modelo.DatosSesion;
import Modelo.GestorUsuarios;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario autenticado.
 */
public class SesionActiva {
    private final Usuario usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final GestorUsuarios gestorUsuarios = new GestorUsuarios();

    /**
     * Constructor que inicializa el usuario y sus datos de sesión.
     *
     * @param usuario usuario autenticado
     */
    public SesionActiva(Usuario usuario) {
        // TODO: Inicializar usuario y datos de sesión
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario.getNombre());
    }

    /**
     * Muestra el menú interactivo de la sesión.
     */
    public void menuSesion() {
        // TODO: Mostrar menú interactivo según el tipo de usuario
    }

    /**
     * Permite ingresar una nueva tarea.
     */
    private void escribirTarea() {
        // TODO: Permitir escribir y guardar una tarea
    }

    /**
     * Muestra todas las tareas del usuario.
     */
    private void mostrarTareas() {
        // TODO: Mostrar todas las tareas disponibles
    }

    /**
     * Registra un nuevo usuario en el archivo login.txt.
     *
     * @param nombre nombre del usuario
     * @param clave contraseña del usuario
     * @return true si fue exitoso, false si hubo error
     */
    private void registrarUsuario() {
        // TODO: Registrar nuevo usuario (solo si es admin)
    }
}
```

##### Modelo/DatosLogin.java

```java
package Modelo;

import java.util.ArrayList;

/**
 * Clase encargada de gestionar el acceso a los datos de login.
 */
public class DatosLogin {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();

    /**
     * Constructor que carga los usuarios desde login.txt
     */
    public DatosLogin() {
        // TODO: Leer login.txt y cargar usuarios a la lista
    }

    /**
     * Devuelve la lista de usuarios cargados.
     *
     * @return lista de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
```

##### Modelo/Usuario.java

```java
package Modelo;

/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario {
    private String nombre;
    private String clave;

    /**
     * Constructor que inicializa los atributos del usuario.
     *
     * @param nombre nombre del usuario
     * @param clave clave del usuario
     */
    public Usuario(String nombre, String clave) {
        // TODO: Inicializar atributos nombre y clave
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
```

##### Modelo/DatosSesion.java

```java
package Modelo;

import java.util.ArrayList;

/**
 * Clase encargada de manejar las tareas de un usuario autenticado.
 */
public class DatosSesion {
    private final String archivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();

    /**
     * Constructor que carga las tareas desde archivo.
     *
     * @param usuario nombre del usuario
     */
    public DatosSesion(String usuario) {
        // TODO: Cargar tareas desde archivo <usuario>_todo.txt
        this.archivo = usuario + "_todo.txt";
    }

    /**
     * Agrega una nueva tarea al archivo del usuario.
     *
     * @param descripcion texto de la tarea
     */
    public void agregarTarea(String descripcion) {
        // TODO: Agregar tarea a la lista y guardarla en el archivo
    }

    /**
     * Devuelve la lista de tareas.
     *
     * @return lista de tareas
     */
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}
```

##### Modelo/Tarea.java

```java
package Modelo;

/**
 * Representa una tarea individual del usuario.
 */
public class Tarea {
    private String descripcion;

    /**
     * Constructor que inicializa la descripción de la tarea.
     *
     * @param descripcion contenido de la tarea
     */
    public Tarea(String descripcion) {
        // TODO: Inicializar descripción
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

```

##### Modelo/GestorUsuarios.java

```java
package Modelo;

/**
 * Clase que permite registrar nuevos usuarios.
 */
public class GestorUsuarios {

    /**
     * Constructor por defecto. Verifica la existencia del archivo de usuarios.
     */
    public GestorUsuarios() {
        // TODO: Verificar o crear archivo login.txt
    }

    /**
     * Registra un nuevo usuario en el archivo login.txt.
     *
     * @param nombre nombre del usuario
     * @param clave contraseña del usuario
     * @return true si fue exitoso, false si hubo error
     */
    public boolean registrar(String nombre, String clave) {
        // TODO: Registrar nuevo usuario en login.txt
        return false;
    }
}
```

