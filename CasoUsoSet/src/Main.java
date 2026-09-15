import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Creamos un conjunto de permisos
        Set<String> permisos = Set.of(
                "LEER",
                "ESCRIBIR",
                "IMPRIMIR"
        );

        // Mostramos los permisos del usuario
        System.out.println("Permisos del usuario:");
        System.out.println(permisos);

        // Prueba 1
        System.out.println("\nPrueba 1:");
        if (permisos.contains("ESCRIBIR")) {
            System.out.println("Puede modificar archivos");
        } else {
            System.out.println("No puede modificar archivos");
        }

        // Prueba 2
        System.out.println("\nPrueba 2:");
        if (permisos.contains("BORRAR")) {
            System.out.println("Puede borrar archivos");
        } else {
            System.out.println("No puede borrar archivos");
        }
    }
}