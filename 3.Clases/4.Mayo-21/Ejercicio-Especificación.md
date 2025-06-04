## Sistema de Login

Desarrollar una aplicación con ejecución por consola que simule un sistema de autenticación básica, con separación clara de responsabilidades entre clases y **acceso a datos externos mediante archivos**.

---
### Estructura del sistema


##### 1. Clase Inicio

* Clase responsable de ser el punto de entrada del programa.
* Solo contiene el método `main`, que crea una instancia de `ConsolaLogin` y llama al método para comenzar el flujo.

---
##### 2. ConsolaLogin

* Clase responsable de manejar la interacción con el usuario mediante consola.
* Funciones:
  * Mostrar menú.
  * En el login solicitar usuario y contraseña.
  * Delegar la verificación de credenciales a la clase `Login`.
  * Mostrar mensajes adecuados según el resultado.
  * Permitir múltiples intentos.
  * Mostrar mensajes de error y volver al menú si la autenticación falla.

---
##### 3. Login

* Clase responsable del proceso de autenticación.
* Funciones:
  * Recibir usuario y contraseña desde `ConsolaLogin`.
  * Consultar los datos en `DatosLogin`.
  * Retornar si la autenticación fue exitosa.

---
##### 4. DatosLogin

* Clase responsable de leer el fichero `login.txt` y proporcionar los datos.
* **Formato de fichero:** cada línea contiene un par `usuario;contraseña`.
* *Funciones:*
  * Leer el fichero de texto una única vez.
  * Almacenar los pares usuario/contraseña en una estructura eficiente.
  * Proveer método para obtener contraseña a partir del usuario.
  * Cerrar adecuadamente recursos de E/S.

---
### Código Base

##### Inicio.java

```java
public class Inicio {
    public static void main(String[] args) {
        ConsolaLogin consola = new ConsolaLogin();
        consola.menu();
    }
}
```

##### ConsolaLogin.java

```java
import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() {
        // TODO: Implementar ciclo del menú principal
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        // TODO: Mostrar "1. Iniciar sesión", "2. Salir"
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(String opcion) {
        // TODO: Si es "1" llamar a manejarLogin, si es "2" salir
    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private void manejarLogin() {
        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
    }
}
```

##### Login.java

```java
/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {

    /**
     * Verifica si existe una línea con el formato exacto "usuario;clave".
     *
     * @param usuario nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @param datos objeto DatosLogin que contiene la lista de credenciales
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean autenticar(String usuario, String clave, DatosLogin datos) {
        // TODO: Crear String intento = usuario + ";" + clave
        // TODO: Recorrer datos.credenciales y comparar con intento
        return false;
    }
}
```

##### DatosLogin.java

```java
import java.util.ArrayList;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        cargarUsuarios();
    }

    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de credenciales.
     */
    private void cargarUsuarios() {
        // TODO: Abrir archivo login.txt
        // TODO: Leer línea por línea y agregar solo las que contienen ";"
        // TODO: Ignorar líneas vacías o mal formateadas
    }
}
```

---
### [OPCIONAL] Pruebas Unitarias

| Prueba                      | ¿Qué verifica?                               | Valor                              |
| --------------------------- | -------------------------------------------- | ---------------------------------- |
| Login válido                | Usuario y contraseña correctos               | Verifica el flujo normal           |
| Usuario inexistente         | Usuario no presente en `login.txt`           | Evalúa control de errores          |
| Contraseña incorrecta       | Usuario existe pero clave no coincide        | Evalúa validación de autenticación |
| Archivo no encontrado       | Archivo `login.txt` no existe o no accesible | Evalúa manejo de errores de E/S    |
| Usuario repetido (opcional) | Dos líneas con el mismo usuario              | Evalúa cómo se comporta el sistema |


