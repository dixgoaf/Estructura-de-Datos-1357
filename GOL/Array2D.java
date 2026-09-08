package GOL;

public class Array2D<T> {

    private int renglones;
    private int columnas;
    private Object[][] datos;

    public Array2D(int renglones, int columnas) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.datos = new Object[renglones][columnas];
    }

    public T obtenerElemento(int renglon, int columna) {
        if (renglon >= 0 && renglon < renglones &&
            columna >= 0 && columna < columnas) {

            return (T) datos[renglon][columna];

        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insertarElemento(int renglon, int columna, T elemento) {
        if (renglon >= 0 && renglon < renglones &&
            columna >= 0 && columna < columnas) {

            datos[renglon][columna] = elemento;

        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int renglones() {
        return renglones;
    }

    public int columnas() {
        return columnas;
    }
}