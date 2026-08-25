import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class RedesSociales {

    public static String[] obtenerFila(String archivo, String red, String concepto) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(red) && datos[1].equals(concepto)) {
                    return datos;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String archivo = "datos_redes_sociales.csv";
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###"); // Limitar a 3 decimales
        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Diferencia de seguidores en Twitter (Enero-Junio)");
            System.out.println("2. Diferencia de visualizaciones en YouTube (meses seleccionados)");
            System.out.println("3. Promedio de crecimiento (Twitter y Facebook)");
            System.out.println("4. Promedio de 'Me gusta' (YouTube, Twitter y Facebook)");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            try {
                switch (opcion) {
                    case 1: {
                        String[] fila = obtenerFila(archivo, "TWITTER", "SEGUIDORES (FOLLOWERS)");
                        int enero = Integer.parseInt(fila[3].replace(",", ""));
                        int junio = Integer.parseInt(fila[8].replace(",", ""));
                        System.out.println("Diferencia seguidores Twitter (Enero-Junio): " + (junio - enero));
                        break;
                    }
                    case 2: {
                        String[] fila = obtenerFila(archivo, "YOUTUBE", "VISUALIZACIONES");
                        System.out.print("Selecciona mes 1 (1=Enero,...,6=Junio): ");
                        int m1 = sc.nextInt();
                        System.out.print("Selecciona mes 2 (1=Enero,...,6=Junio): ");
                        int m2 = sc.nextInt();
                        int val1 = Integer.parseInt(fila[m1 + 2]);
                        int val2 = Integer.parseInt(fila[m2 + 2]);
                        System.out.println("Diferencia visualizaciones YouTube: " + (val2 - val1));
                        break;
                    }
                    case 3: {
                        String[] filaTwitter = obtenerFila(archivo, "TWITTER", "CRECIMIENTO DE FOLLOWERS");
                        String[] filaFacebook = obtenerFila(archivo, "FACEBOOK", "CRECIMIENTO (seguidores)");
                        int sumaT = 0, sumaF = 0;
                        for (int i = 3; i <= 8; i++) {
                            sumaT += Integer.parseInt(filaTwitter[i].replace(",", ""));
                            sumaF += Integer.parseInt(filaFacebook[i].replace(",", ""));
                        }
                        System.out.println("Promedio crecimiento Twitter: " + df.format(sumaT / 6.0));
                        System.out.println("Promedio crecimiento Facebook: " + df.format(sumaF / 6.0));
                        break;
                    }
                    case 4: {
                        String[] filaTwitter = obtenerFila(archivo, "TWITTER", "ME GUSTA");
                        String[] filaFacebook = obtenerFila(archivo, "FACEBOOK", "ME GUSTA EN PUBLICACIONES");
                        String[] filaYoutube = obtenerFila(archivo, "YOUTUBE", "ME GUSTA");
                        int sumaT = 0, sumaF = 0, sumaY = 0;
                        for (int i = 3; i <= 8; i++) {
                            sumaT += Integer.parseInt(filaTwitter[i]);
                            sumaF += Integer.parseInt(filaFacebook[i]);
                            sumaY += Integer.parseInt(filaYoutube[i]);
                        }
                        System.out.println("Promedio Me gusta Twitter: " + df.format(sumaT / 6.0));
                        System.out.println("Promedio Me gusta Facebook: " + df.format(sumaF / 6.0));
                        System.out.println("Promedio Me gusta YouTube: " + df.format(sumaY / 6.0));
                        break;
                    }
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida, intenta de nuevo.");
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

        } while (opcion != 5);

        sc.close();
    }
}
