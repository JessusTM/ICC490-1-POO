import java.util.Scanner;

public class NaveHiperEspacio {

    public static void main(String[] args) {
        menu();
    }

    /**
     * Método que controla el ciclo principal del programa.
     */
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            ejecutarOpcion(opcion, sc);
        } while (opcion != 6);
        sc.close();
        System.out.println("¡Saliendo del programa!");
    }

    /**
     * Imprime el menú principal.
     */
    public static void mostrarMenu() {
        System.out.println("\n======================");
        System.out.println("    Nave HiperEspacio   ");
        System.out.println("      Matrices 2 x 2    ");
        System.out.println("======================= ");
        System.out.println("    [1] Suma            ");
        System.out.println("    [2] Resta           ");
        System.out.println("    [3] Multiplicación  ");
        System.out.println("    [4] Inversa         ");
        System.out.println("    [5] División        ");
        System.out.println("    [6] Salir           ");
        System.out.println("======================= ");
        System.out.print("      Opción: ");
    }

    /**
     * Ejecuta la opción elegida llamando al método específico para cada operación.
     */
    public static void ejecutarOpcion(int opcion, Scanner sc) {
        switch (opcion) {
            case 1:
                operacionSuma(sc);
                break;
            case 2:
                operacionResta(sc);
                break;
            case 3:
                operacionMultiplicacion(sc);
                break;
            case 4:
                operacionInversa(sc);
                break;
            case 5:
                operacionDivision(sc);
                break;
            case 6:
                break;
            default:
                System.out.println("Opción no válida...");
                break;
        }
    }

    /**
     * Operación de suma de matrices usando la entrada por consola.
     */
    public static void operacionSuma(Scanner sc) {
        System.out.println("\n      # ----- Suma de Matrices ----- # ");
        double[][] matrizA = leerMatriz(sc, "primera");
        double[][] matrizB = leerMatriz(sc, "segunda");
        double[][] resultado = sumaMatrices(matrizA, matrizB);
        System.out.println("        Resultado de la suma:");
        imprimirMatriz(resultado);
    }

    /**
     * Operación de resta de matrices usando la entrada por consola.
     */
    public static void operacionResta(Scanner sc) {
        System.out.println("\n      # ----- Resta de Matrices ----- # ");
        double[][] matrizA = leerMatriz(sc, "primera");
        double[][] matrizB = leerMatriz(sc, "segunda");
        double[][] resultado = restaMatrices(matrizA, matrizB);
        System.out.println("        Resultado de la resta:");
        imprimirMatriz(resultado);
    }

    /**
     * Operación de multiplicación de matrices usando la entrada por consola.
     */
    public static void operacionMultiplicacion(Scanner sc) {
        System.out.println("\n      # ----- Multiplicación de Matrices ----- # ");
        double[][] matrizA = leerMatriz(sc, "primera");
        double[][] matrizB = leerMatriz(sc, "segunda");
        double[][] resultado = multiplicacionMatrices(matrizA, matrizB);
        System.out.println("        Resultado de la multiplicación:");
        imprimirMatriz(resultado);
    }

    /**
     * Operación de cálculo de la inversa de una matriz usando la entrada por consola.
     */
    public static void operacionInversa(Scanner sc) {
        System.out.println("\n      # ----- Inversa de Matriz ----- # ");
        double[][] matriz = leerMatriz(sc, "única");
        double[][] inversa = inversaMatriz(matriz);
        if (inversa == null) {
            System.out.println("        La matriz no es invertible (determinante 0).");
            return;
        }
        System.out.println("        Resultado de la inversa:");
        imprimirMatriz(inversa);
    }

    /**
     * Operación de división de matrices (resuelve A * X = B) usando la entrada por consola.
     */
    public static void operacionDivision(Scanner sc) {
        System.out.println("\n      # ----- División de Matrices ----- # ");
        double[][] matrizA = leerMatriz(sc, "A (debe ser invertible)");
        double[][] matrizB = leerMatriz(sc, "B");
        double[][] resultado = divisionMatrices(matrizA, matrizB);
        if (resultado == null) {
            System.out.println("        La matriz A no es invertible.");
            return;
        }
        System.out.println("        Resultado de la división (X):");
        imprimirMatriz(resultado);
    }

    /**
     * Lee una matriz 2x2 desde la entrada estándar.
     */
    public static double[][] leerMatriz(Scanner sc, String nombre) {
        double[][] matriz = new double[2][2];
        System.out.println("        Ingrese la matriz " + nombre + ":");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("        Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }
        return matriz;
    }

    /**
     * Imprime una matriz 2x2.
     */
    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < 2; i++) {
            System.out.println(matriz[i][0] + "  " + matriz[i][1]);
        }
    }

    /**
     * Calcula el determinante de una matriz 2x2.
     */
    public static double determinante(double[][] matriz) {
        return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
    }

    // Métodos auxiliares que reciben matrices directamente:

    /**
     * Suma dos matrices 2x2.
     */
    public static double[][] sumaMatrices(double[][] A, double[][] B) {
        double[][] resultado = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                resultado[i][j] = A[i][j] + B[i][j];
            }
        }
        return resultado;
    }

    /**
     * Resta dos matrices 2x2.
     */
    public static double[][] restaMatrices(double[][] A, double[][] B) {
        double[][] resultado = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                resultado[i][j] = A[i][j] - B[i][j];
            }
        }
        return resultado;
    }

    /**
     * Multiplica dos matrices 2x2.
     */
    public static double[][] multiplicacionMatrices(double[][] A, double[][] B) {
        double[][] resultado = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return resultado;
    }

    /**
     * Calcula la inversa de una matriz 2x2. Retorna null si la matriz no es invertible.
     */
    public static double[][] inversaMatriz(double[][] A) {
        double det = determinante(A);
        if (det == 0) {
            return null;
        }
        double[][] inversa = new double[2][2];
        inversa[0][0] = A[1][1] / det;
        inversa[0][1] = -A[0][1] / det;
        inversa[1][0] = -A[1][0] / det;
        inversa[1][1] = A[0][0] / det;
        return inversa;
    }

    /**
     * Resuelve la ecuación A * X = B para X, usando la inversa de A.
     * Retorna null si A no es invertible.
     */
    public static double[][] divisionMatrices(double[][] A, double[][] B) {
        double[][] inversaA = inversaMatriz(A);
        if (inversaA == null) {
            return null;
        }
        return multiplicacionMatrices(inversaA, B);
    }
}

