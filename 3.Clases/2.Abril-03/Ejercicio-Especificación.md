## Salto al HiperEspacio

### Descripción del ejercicio

Para asegurar que cada nave de la flota imperial realice sus saltos al hiperespacio con la máxima precisión, se debe implementar algoritmos basados en cálculos algebraicos que operan sobre matrices de $2 x 2$. Gracias a estas estructuras, es posible modelar de forma detallada la orientación, posición y la integración de múltiples sistemas de sensores y control. Con ello, no solo se optimizan las maniobras y la estabilidad de la trayectoria, sino que también se garantiza que la nave se mantenga siempre lista para el combate.

Como desarrollador imperial, la misión asignada consiste en diseñar un programa en Java que permita realizar las siguientes operaciones. Para cada operación, el usuario deberá proporcionar la información de de las dos matrices $2 x 2$ en tiempo de ejecución:

##### 1. Suma de Matrices

Dadas dos matrices $2 x 2$, $A$ y $B$, su suma $C = A + B$ se obtiene al sumar cada elemento correspondiente:

$$
C_{ij} = A_{ij} + B_{ij}
$$
$$
C = 
\begin{pmatrix}
a_{11} + b_{11} & a_{21} + b_{21} \\
a_{12} + b_{12} & a_{22} + b_{22}
\end{pmatrix}
$$

> Esta operación permite integrar simultáneamente datos provenientes de diversos subsistemas de la nave, como posición, velocidad y orientación. Gracias a esta operación se obtiene una imagen precisa y unificada de la situación actual de la nave para ajustar dinámicamente la trayectoria y mantener la estabilidad del curso en los saltos a hiperespacio.

##### 2. Resta de Matrices

Para dos matrices $2 x 2$, $A$ y $B$, la resta $C = A - B$ se lleva a cabo sustrayendo cada elemento correspondiente:

$$
C_{ij} = A_{ij} - B_{ij}
$$
$$
C =
\begin{pmatrix}
a_{11} - b_{11} & a_{21} - b_{21} \\
a_{12} - b_{12} & a_{22} - b_{22}
\end{pmatrix}
$$

> Esta operación determina las discrepancias entre el estado real y el estado deseado de la nave. Al restar la matriz de configuración ideal de la matriz que representa la situación actual, se obtiene una «matriz de error» que señala las desviaciones existentes, permitiendo realizar correcciones de manera precisa en los sistemas de control.

##### 3. Multiplicación de Matrices

La multiplicación de dos matrices $2 x 2$, $C = A \times B$, se define como:

$$
C_{ij} = \sum_{k=1}^{2} A_{ik} \, B_{kj}
$$

Para esta operación, las matrices $A$ y $B$ deben ser estrictamente de dimensiones $2 x 2$, ya que se necesita que el número de columnas de la primera matriz coincida con el número de filas de la segunda matriz.

> Esta operación constituye el núcleo para transformar coordenadas y combinar diversos sistemas de referencia. Al multiplicar matrices de transformación, se modela el cambio de orientación de la nave en el espacio, así como la dirección y magnitud de la velocidad, factores decisivos para maniobras complejas, especialmente durante un salto a hiperespacio.

##### 4. Cálculo de la Inversa de una Matriz

Sea una matriz $2 \times 2$ $A$ dada por:

$$
A = \begin{pmatrix}
a & b \\
c & d
\end{pmatrix}
$$

La inversa $A^{-1}$ existe si y solo si el determinante: $\det(A) = ad - bc$, es distinto de 0. De ser así, se calcula como:

$$
A^{-1} = \frac{1}{ad - bc}
\begin{pmatrix}
d & -b \\
-c & a
\end{pmatrix}
$$

> Esta operación permite obtener correcciones exactas en los parámetros de la nave, asegurando que cada ajuste cumpla con los requisitos matemáticos y operativos en situaciones críticas.

##### 5. División de Matrices (Uso de la Inversa)

La división directa entre matrices no está definida. Sin embargo, cuando $A$ es invertible en la ecuación $A X = B$, se despeja $X$ multiplicando ambos lados por $A^{-1}$:

$$
X = A^{-1} B
$$

> Este procedimiento permite establecer con exactitud las correcciones necesarias en los parámetros de vuelo, garantizando la fiabilidad y el éxito en la ejecución de un salto a hiperespacio.

---
### Código Base

```java
import java.util.Scanner;

public class NaveHiperEspacio {

    /**
     * Método principal que inicia la aplicación.
     * TODO: Llamar al método menu para iniciar la interacción con el usuario.
     */
    public static void main(String[] args) {
        // TODO: Invocar menu();
    }

    /**
     * Menú principal con un do-while para manejar las opciones del usuario.
     * TODO: Incluir el ciclo do-while y las llamadas a mostrarMenu y ejecutarOpcion.
     */
    public static void menu() {
        // TODO: Implementar ciclo do-while, leer opción y llamar a ejecutarOpcion.
    }

    /**
     * Imprime el menú principal.
     * TODO: Mostrar las opciones disponibles para el usuario.
     */
    public static void mostrarMenu() {
        // TODO: Mostrar opciones: 1. Suma, 2. Resta, 3. Multiplicación, 4. Inversa, 5. División, 6. Salir.
    }

    /**
     * Ejecuta la opción elegida llamando al método específico para cada operación.
     * TODO: Evaluar la opción ingresada y redirigir a la operación correspondiente.
     */
    public static void ejecutarOpcion(int opcion, Scanner sc) {
        // TODO: Implementar switch-case para cada opción (1 a 6).
    }

    /**
     * Realiza la operación de suma de dos matrices 2x2.
     * TODO: Leer dos matrices 2x2, sumar elemento a elemento e imprimir el resultado.
     */
    public static void operacionSuma(Scanner sc) {
        // TODO: Invocar leerMatriz para ambas matrices, sumar y llamar a imprimirMatriz.
    }

    /**
     * Realiza la operación de resta de dos matrices 2x2.
     * TODO: Leer dos matrices 2x2, restar elemento a elemento e imprimir el resultado.
     */
    public static void operacionResta(Scanner sc) {
        // TODO: Invocar leerMatriz para ambas matrices, restar y llamar a imprimirMatriz.
    }

    /**
     * Realiza la operación de multiplicación de dos matrices 2x2.
     * TODO: Leer dos matrices 2x2, multiplicarlas utilizando la suma de productos y mostrar el resultado.
     */
    public static void operacionMultiplicacion(Scanner sc) {
        // TODO: Invocar leerMatriz para ambas matrices, multiplicar y llamar a imprimirMatriz.
    }

    /**
     * Realiza la operación de cálculo de la inversa de una matriz 2x2.
     * TODO: Leer una matriz 2x2, calcular su determinante, verificar invertibilidad y mostrar la inversa.
     */
    public static void operacionInversa(Scanner sc) {
        // TODO: Invocar leerMatriz, calcular determinante, verificar y calcular la inversa, luego llamar a imprimirMatriz.
    }

    /**
     * Realiza la operación de división de matrices resolviendo A * X = B.
     * TODO: Leer la matriz A, verificar que sea invertible, calcular su inversa, leer la matriz B y mostrar el resultado de A^-1 * B.
     */
    public static void operacionDivision(Scanner sc) {
        // TODO: Invocar leerMatriz para A y B, calcular inversa de A, multiplicar por B y llamar a imprimirMatriz.
    }

    /**
     * Lee una matriz 2x2 desde la entrada estándar.
     * TODO: Solicitar al usuario cada elemento de la matriz especificada y retornar la matriz.
     */
    public static double[][] leerMatriz(Scanner sc, String nombre) {
        // TODO: Implementar lectura de 2x2 elementos y retornar la matriz.
    }

    /**
     * Imprime una matriz 2x2 en formato sencillo.
     * TODO: Recorrer la matriz y mostrar cada uno de sus elementos.
     */
    public static void imprimirMatriz(double[][] matriz) {
        // TODO: Implementar impresión de cada elemento de la matriz.
    }

    /**
     * Calcula el determinante de una matriz 2x2.
     * TODO: Calcular y retornar el determinante utilizando la fórmula: ad - bc.
     */
    public static double determinante(double[][] matriz) {
        // TODO: Implementar el cálculo del determinante.
    }
}
```
---
### Preguntas
Sea $n$ un número entero mayor que $2$: 
  * ¿qué se debería cambiar en el código si las matrices fuesen $n×n$?
  * ¿Qué se debería cambiar en el código si las matrices fueran $3x3$? 
  * ¿Cómo se asegura que el resultado de cada operación es el correcto?

---
### Resultados de Aprendizaje Esperados
* Implementación de un menú interactivo por consola.

* Uso de un repositorio Git y GitHub para documentar y rastrear el desarrollo.

* Aplicación del principio de responsabilidad única (SRP) en los métodos.

* Manejo de matrices 2x2 y sus operaciones fundamentales (suma, resta, multiplicación, inversa).
