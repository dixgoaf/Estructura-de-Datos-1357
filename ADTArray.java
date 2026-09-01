package tarea2;
public class ADTArray {

    private Trabajador[] datos;
    private int cantidad;

    public ADTArray(int tamano) {
        datos = new Trabajador[tamano];
        cantidad = 0;
    }

    public boolean agregar(Trabajador trabajador) {

        if (cantidad < datos.length) {
            datos[cantidad] = trabajador;
            cantidad++;
            return true;
        }

        return false;
    }

    public Trabajador obtener(int posicion) {

        if (posicion >= 0 && posicion < cantidad) {
            return datos[posicion];
        }

        return null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Trabajador mayorAntiguedad() {

        Trabajador mayor = datos[0];

        for (int i = 1; i < cantidad; i++) {

            if (datos[i].getAntiguedad() > mayor.getAntiguedad()) {
                mayor = datos[i];
            }
        }

        return mayor;
    }

    public Trabajador menorAntiguedad() {

        Trabajador menor = datos[0];

        for (int i = 1; i < cantidad; i++) {

            if (datos[i].getAntiguedad() < menor.getAntiguedad()) {
                menor = datos[i];
            }
        }

        return menor;
    }

    public void mostrarTodos() {

        for (int i = 0; i < cantidad; i++) {
            datos[i].mostrarDatos();
        }
    }
}