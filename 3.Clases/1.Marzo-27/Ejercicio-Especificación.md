## **Sistema de Gestión de Pistolas – Imperio de Palpatine**  

### Descripción del ejercicio  

El Emperador Palpatine y su alto comité imperial han detectado una preocupante deficiencia en la logística del equipamiento militar: durante los enfrentamientos contra la Rebelión, numerosas pistolas imperiales se extravían en el fragor de la batalla, debilitando la eficiencia operativa de las tropas. Ante esta crisis, se ha ordenado el desarrollo de un sistema que optimice la gestión del inventario de armamento.  

Como desarrollador imperial, tu misión asignada consiste en diseñar un programa en Java que permita:  

- **Agregar** nuevas pistolas al inventario. 

> Se debe considerar que todas son del mismo modelo estándar, asignadas exclusivamente a los soldados del frente. Por ello, cada pistola se registrará con dos atributos: un **ID** y el **nombre del soldado asignado**.  

- **Eliminar** aquellas que se hayan extraviado, capturado por la Rebelión o dañado en combate.  
- **Listar** todas las pistolas registradas en el inventario imperial.  
- **Buscar** pistolas por su identificador único o por el nombre del soldado que la tiene asignada.  

---
### Especificaciones  

- Cada método deberá realizar una única función y no tener más de 10 lineas.
- Contará con un método `main` que invoca únicamente un **menú interactivo por consola**.  
- Se utilizarán **arreglos** para almacenar y gestionar la lista de pistolas.  
- Se deberá registrar todo el progreso del desarrollo en un **repositorio de GitHub**, asegurando un control de versiones eficiente.  

---
### Código Base
```Java
import java.util.Scanner;

public class PistolasImperio {
    private static final int MAX_PISTOLAS = 100;
    private static String[][] pistolas = new String[MAX_PISTOLAS][2]; // [ID, NombreSoldado]
    private static int totalPistolas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

     /**
    * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
    */
    public static void menu() {
        // TODO: Implementar el código para gestionar la interacción con el usuario.
    }

    /**
     * Muestra el menú principal con las opciones disponibles.
     */
    private static void mostrarOpciones() {
        // TODO: Implementar el código para mostrar las opciones del menú en pantalla.
    }

    /**
     * Obtiene y valida la opción ingresada por el usuario.
     * @return La opción seleccionada.
     */
    private static int obtenerOpcion() {
        // TODO: Implementar la lectura y validación de la opción ingresada.
    }

    /**
     * Ejecuta la acción correspondiente según la opción seleccionada.
     * @param opcion Opción ingresada por el usuario.
     */
    private static void ejecutarOpcion(int opcion) {
        // TODO: Implementar la lógica para ejecutar la opción seleccionada.
    }

    /**
     * Agrega una nueva pistola al inventario, registrando su ID y el nombre del soldado.
     */
    private static void agregarPistola() {
        // TODO: Implementar la lógica para agregar una pistola al inventario.
    }

    /**
     * Elimina una pistola del inventario según su ID.
     */
    private static void eliminarPistola() {
        // TODO: Implementar la lógica para eliminar una pistola del inventario.
    }

    /**
     * Reorganiza el inventario después de eliminar una pistola, evitando espacios vacíos.
     * @param indice Índice de la pistola eliminada.
     */
    private static void reordenarInventario(int indice) {
        // TODO: Implementar la lógica para reorganizar el inventario después de una eliminación.
    }

    /**
     * Muestra en pantalla todas las pistolas registradas en el inventario.
     */
    private static void listarPistolas() {
        // TODO: Implementar la lógica para listar todas las pistolas registradas.
    }
}
```
---
### Resultados de aprendizaje esperados  

- Implementación de un **menú interactivo por consola** para la gestión del inventario.  
- Uso de un **repositorio Git y GitHub** para documentar el desarrollo.  
- Aplicación del **principio de responsabilidad única** en los métodos.  
- Manejo de **arreglos** para la gestión eficiente de datos.  

---
### Material de Apoyo
[Apuntes Java Jesús](https://github.com/JessusTM/ICC490-1-POO#)
<br>
[Generar menú en Java con do-while](https://www.youtube.com/watch?v=D-iUim3WLK0&t=53s&ab_channel=SinRuedaTecnol%C3%B3gica)
