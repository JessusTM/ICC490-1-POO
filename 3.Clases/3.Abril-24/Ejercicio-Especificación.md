### Carrito de Compras

Desarrollar programa que simule el funcionamiento básico de un carrito de compras: 
* Gestionar productos 
* Calcular el total 
* Aplicar descuentos. 

El objetivo del ejercicio es seguir fortaleciendo el diseño de código limpio y aplicar **pruebas unitarias significativas** utilizando JUnit, enfocadas en verificar funcionalidades clave del sistema mediante casos de prueba que aporten valor.

---
#### Requisitos

- El proyecto debe estar vinculado a un repositorio en GitHub.
- Todo el código debe estar contenido en una única clase pública denominada `Carrito`.
- Todos los métodos de la clase deben ser `public static`.
- La lógica implementada debe permitir la construcción de casos de prueba **relevantes y no triviales**, que reflejen situaciones reales de uso.
- Se deben aplicar las **buenas prácticas de programación** revisadas durante el curso.

---
### Código Base
```java
import java.util.Scanner;

public class Carrito {
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
     * Agrega un producto al carrito.
     */
    private static void agregarProducto() {
        // TODO: Solicitar nombre y precio, validar, y agregar al carrito si no existe.
    }

    /**
     * Elimina un producto del carrito por su nombre.
     */
    private static void eliminarProducto() {
        // TODO: Solicitar nombre del producto y eliminarlo si existe.
    }

    /**
     * Calcula e imprime el total de todos los productos del carrito.
     */
    private static void calcularTotal() {
        // TODO: Sumar todos los precios de los productos y mostrar el resultado.
    }

    /**
     * Aplica un tipo de descuento al total (porcentaje o monto fijo).
     */
    private static void aplicarDescuento() {
        // TODO: Solicitar tipo de descuento e imprimir el total con el descuento aplicado.
    }

    /**
     * Muestra todos los productos actualmente en el carrito.
     */
    private static void listarProductos() {
        // TODO: Mostrar todos los productos con sus respectivos precios.
    }
}
```

---
### Pruebas Unitarias

Una vez implementada la lógica de negocio se deberá generar un archivo de pruebas unitarias mediante el IDE, con **casos de prueba que entreguen valor real** y eviten validaciones triviales. A continuación ejemplos de pruebas relevantes que deberán ser implementadas:

| Prueba                          | ¿Qué verifica?                                                             | ¿Por qué tiene valor?                                                                 |
|----------------------------------|----------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| `testAgregarProductoValido`      | Que un producto válido se agregue correctamente.                          | Verifica que se puede construir el carrito correctamente.                             |
| `testAgregarProductoRepetido`    | Que no se permita agregar dos veces el mismo producto.                    | Evita inconsistencias y duplicaciones en la lógica de datos.                          |
| `testEliminarProductoExistente`  | Que se pueda eliminar un producto que está en el carrito.                 | Confirma la capacidad de modificar el contenido del carrito.                          |
| `testEliminarProductoInexistente`| Que no se elimine un producto que no existe.                              | Garantiza estabilidad ante operaciones erróneas.                                       |
| `testCalcularTotalMultiple`      | Que el total se calcule correctamente con varios productos.               | Asegura el funcionamiento base del carrito.                                            |
| `testAplicarDescuentoFijo`       | Que se aplique correctamente un descuento de monto fijo.                  | Evalúa la lógica de rebajas con reglas fijas.                                          |
| `testAplicarDescuentoPorcentaje` | Que se aplique correctamente un descuento porcentual.                     | Asegura que los cálculos proporcionales se ejecuten correctamente.                    |
| `testDescuentoTipoInvalido`      | Que al usar un tipo de descuento inválido, no se aplique nada.            | Previene errores por uso indebido de la funcionalidad.                                |

---
### Preguntas

1. ¿Qué ocurre si se intenta agregar un producto con precio negativo?
2. ¿Qué comportamiento debería esperarse si el tipo de descuento está mal escrito o es `null`?
3. ¿Qué valor debería retornar el método `eliminarProducto` si el carrito está vacío?
4. ¿Cómo afectaría el uso de mayúsculas y minúsculas en los nombres de productos al intentar eliminarlos?
5. ¿Qué debería ocurrir si se aplica un descuento mayor al total acumulado en el carrito?

--- 
### Sección 2: Extensión de Funcionalidades

Con el objetivo de ampliar la cobertura funcional del sistema y fomentar el desarrollo de pruebas unitarias, se deberá integrar nuevas funcionalidades bajo los mismos criterios de diseño definidos en los requisitos iniciales: 
  * Uso de una única clase pública. 
  * Métodos public static. 
  * Lógica preparada para ser testeada unitariamente.

##### 1. Funcionalidad: Actualizar Precio de un Producto
Esta funcionalidad permite modificar el precio de un producto previamente agregado al carrito, siempre que dicho producto exista y que el nuevo precio sea válido (no negativo).

##### 2. Funcionalidad: Vaciar el Carrito
Se propone incluir una operación que elimine todos los productos y sus precios, dejando el carrito en estado inicial.

##### Pruebas 
| Prueba                               | ¿Qué verifica?                                                                | ¿Por qué tiene valor?                                                                 |
|--------------------------------------|--------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| `testActualizarPrecioProductoExistente`   | Que se actualice correctamente el precio de un producto existente.         | Permite modificar valores sin duplicar entradas ni perder integridad.                |
| `testActualizarPrecioProductoInexistente` | Que no se actualice el precio si el producto no existe en el carrito.      | Garantiza que la operación solo afecte datos válidos.                                |
| `testActualizarPrecioNegativo`           | Que no se permita asignar un precio negativo a ningún producto.             | Previene errores lógicos y asegura consistencia en los datos financieros.            |
| `testVaciarCarritoConProductos`          | Que todos los productos sean eliminados correctamente si el carrito tiene elementos. | Verifica la capacidad del sistema de reiniciarse completamente.                 |
| `testVaciarCarritoYaVacio`               | Que el vaciado funcione correctamente incluso si el carrito ya está vacío. | Asegura estabilidad ante acciones repetitivas o redundantes.                         |

