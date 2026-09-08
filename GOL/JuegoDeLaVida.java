package GOL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuegoDeLaVida {

    public static Array2D<Integer> leerCSV(String archivo)
            throws IOException {

        BufferedReader br = new BufferedReader(
            new FileReader(archivo)
        );

        String linea;
        int renglones = 0;
        int columnas = 0;

        // Contar renglones y columnas
        while ((linea = br.readLine()) != null) {

            renglones++;

            String[] valores = linea.split(",");

            if (valores.length > columnas) {
                columnas = valores.length;
            }
        }

        br.close();

        Array2D<Integer> tablero =
            new Array2D<>(renglones, columnas);

        br = new BufferedReader(
            new FileReader(archivo)
        );

        int renglon = 0;

        while ((linea = br.readLine()) != null) {

            String[] valores = linea.split(",");

            for (int columna = 0;
                 columna < valores.length;
                 columna++) {

                int valor = Integer.parseInt(
                    valores[columna].trim()
                );

                tablero.insertarElemento(
                    renglon,
                    columna,
                    valor
                );
            }

            renglon++;
        }

        br.close();

        return tablero;
    }

    public static int contarVecinos(
            Array2D<Integer> tablero,
            int renglon,
            int columna) {

        int vecinos = 0;

        for (int i = -1; i <= 1; i++) {

            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int nuevoRenglon = renglon + i;
                int nuevaColumna = columna + j;

                if (nuevoRenglon >= 0 &&
                    nuevoRenglon < tablero.renglones() &&
                    nuevaColumna >= 0 &&
                    nuevaColumna < tablero.columnas()) {

                    if (tablero.obtenerElemento(
                            nuevoRenglon,
                            nuevaColumna) == 1) {

                        vecinos++;
                    }
                }
            }
        }

        return vecinos;
    }

    public static Array2D<Integer> siguienteGeneracion(
            Array2D<Integer> tablero) {

        Array2D<Integer> siguiente =
            new Array2D<>(
                tablero.renglones(),
                tablero.columnas()
            );

        for (int i = 0; i < tablero.renglones(); i++) {

            for (int j = 0; j < tablero.columnas(); j++) {

                int actual =
                    tablero.obtenerElemento(i, j);

                int vecinos =
                    contarVecinos(tablero, i, j);

                // Celula viva
                if (actual == 1) {

                    // Sobrevive con 2 o 3 vecinos
                    if (vecinos == 2 || vecinos == 3) {
                        siguiente.insertarElemento(i, j, 1);
                    } else {
                        siguiente.insertarElemento(i, j, 0);
                    }

                } 
                // Celula muerta
                else {

                    // Nace si tiene exactamente 3 vecinos
                    if (vecinos == 3) {
                        siguiente.insertarElemento(i, j, 1);
                    } else {
                        siguiente.insertarElemento(i, j, 0);
                    }
                }
            }
        }

        return siguiente;
    }

    public static void mostrar(
            Array2D<Integer> tablero) {

        for (int i = 0; i < tablero.renglones(); i++) {

            for (int j = 0; j < tablero.columnas(); j++) {

                if (tablero.obtenerElemento(i, j) == 1) {
                    System.out.print("■ ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        try {

            Array2D<Integer> tablero =
                leerCSV("poblacion.csv");

            // Mostrar 10 generaciones
            for (int generacion = 1;
     generacion <= 10;
     generacion++) {

    System.out.println(
        "\nGeneracion " + generacion
    );

    mostrar(tablero);

    tablero =
        siguienteGeneracion(tablero);
}

        } catch (IOException e) {

            System.out.println(
                "Error al leer el archivo: "
                + e.getMessage()
            );
        }
    }
}