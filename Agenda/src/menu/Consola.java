package menu;
import java.util.Scanner;

public class Consola {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero() {
        try {
            int entero = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            return entero;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número entero válido.");
            scanner.nextLine(); // Limpiar el buffer de entrada
            return leerEntero(); // Llamada recursiva para intentar de nuevo
        }
    }

    public static String leerCadena() {
        return scanner.nextLine();
    }
}


