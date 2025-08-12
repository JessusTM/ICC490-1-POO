import java.util.Scanner;

public class PistolasImperio {
    private static final int MAX_PISTOLAS = 100;
    private static String[][] pistolas = new String[MAX_PISTOLAS][2]; // [ID, NombreSoldado]
    private static int totalPistolas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }

    private static void mostrarOpciones() {
        System.out.println("\n=============================" );
        System.out.println("            IMPERIO            " );
        System.out.println("      Gestión de Pistolas      " );
        System.out.println("============================= " );
        System.out.println("    [1] Agregar pistola       " );
        System.out.println("    [2] Eliminar pistola      " );
        System.out.println("    [3] Listar pistolas       " );
        System.out.println("    [4] Buscar pistola        " );
        System.out.println("    [5] Salir                 " );
        System.out.println("============================= " );
        System.out.print("      Opcion: ");
    }

    private static int obtenerOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarPistola();
            case 2 -> eliminarPistola();
            case 3 -> listarPistolas();
            case 4 -> buscarPistola();
            case 5 -> System.out.println("  Hasta luego...");
            default -> System.out.println(" Opcion invalida...");
        }
    }

    private static void agregarPistola() {
        if (totalPistolas >= MAX_PISTOLAS) {
            System.out.println("    Inventario lleno...");
            return;
        }
  
        System.out.println("\n    -------- AGREGAR PISTOLA -------- ");
        System.out.print  ("          ID        : ");
        String id = scanner.nextLine();

        System.out.print  ("          Soldado   : ");
        String nombre = scanner.nextLine();

        pistolas[totalPistolas][0] = id;
        pistolas[totalPistolas][1] = nombre;
        totalPistolas++;

        System.out.println("    Pistola agregada exitosamente...");
    }

    private static void eliminarPistola() {
        System.out.println("\n    -------- ELIMINAR PISTOLA --------");
        System.out.print  ("          ID: ");
        String id = scanner.nextLine();

        for (int i = 0; i < totalPistolas; i++) {
            if (pistolas[i][0].equals(id)) {
                reordenarInventario(i);
                System.out.println("      Pistola eliminada exitosamente...");
                return;
            }
        }
        System.out.println("    No existe una pistola con ese ID...");
    }

    private static void reordenarInventario(int indice) {
        for (int i = indice; i < totalPistolas - 1; i++) {
            pistolas[i] = pistolas[i + 1];
        }
        pistolas[totalPistolas - 1] = new String[2];
        totalPistolas--;
    }

    private static void listarPistolas() {
        if (totalPistolas == 0) {
            System.out.println("    No hay pistolas en el inventario...");
            return;
        }
        System.out.println("\n    ------ INVENTARIO ------ ");
        for (int i = 0; i < totalPistolas; i++) {
            System.out.printf("       ID: %s, Soldado: %s\n", pistolas[i][0], pistolas[i][1]);
        }
        System.out.println();
    }

    private static void buscarPistola() {
        System.out.println("\n    -------- BUSCAR PISTOLA --------");
        System.out.print  ("          ID: ");
        String id = scanner.nextLine();

        for (int i = 0; i < totalPistolas; i++) {
            if (pistolas[i][0].equals(id)) {
                System.out.printf("     Encontrado - ID: %s, Soldado: %s\n\n", pistolas[i][0], pistolas[i][1]);
                return;
            }
        }
        System.out.println("      No se encontraron coincidencias...");
    }
}
