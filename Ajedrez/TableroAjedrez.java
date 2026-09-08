package Ajedrez;

public class TableroAjedrez {

    public static void main(String[] args) {

        Array2D<String> tablero = new Array2D<>(8, 8);

        String[] piezasNegras = {
            "\u265C",
            "\u265E",
            "\u265D",
            "\u265B",
            "\u265A",
            "\u265D",
            "\u265E",
            "\u265C"
        };

        String[] piezasBlancas = {
            "\u2656",
            "\u2658",
            "\u2657",
            "\u2655",
            "\u2654",
            "\u2657",
            "\u2658",
            "\u2656"
        };

        // Piezas negras
        for (int i = 0; i < 8; i++) {
            tablero.insertarElemento(0, i, piezasNegras[i]);
        }

        // Peones negros
        for (int i = 0; i < 8; i++) {
            tablero.insertarElemento(1, i, "\u265F");
        }

        // Espacios vacíos
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                tablero.insertarElemento(i, j, " ");
            }
        }

        // Peones blancos
        for (int i = 0; i < 8; i++) {
            tablero.insertarElemento(6, i, "\u2659");
        }

        // Piezas blancas
        for (int i = 0; i < 8; i++) {
            tablero.insertarElemento(7, i, piezasBlancas[i]);
        }

        // Mostrar tablero
        System.out.println("    A   B   C   D   E   F   G   H");
        System.out.println("  +---+---+---+---+---+---+---+---+");

        for (int i = 0; i < 8; i++) {

            System.out.print((8 - i) + " |");

            for (int j = 0; j < 8; j++) {
                System.out.print(" "
                        + tablero.obtenerElemento(i, j)
                        + " |");
            }

            System.out.println(" " + (8 - i));

            System.out.println(
                "  +---+---+---+---+---+---+---+---+"
            );
        }

        System.out.println("    A   B   C   D   E   F   G   H");
    }
}