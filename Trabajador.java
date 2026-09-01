package tarea2;
public class Trabajador {

    private int numeroTrabajador;
    private String nombres;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int anioIngreso;

    public Trabajador(int numeroTrabajador, String nombres, String paterno,
                      String materno, int horasExtra, double sueldoBase,
                      int anioIngreso) {

        this.numeroTrabajador = numeroTrabajador;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }

    public int getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public int getAntiguedad() {
        return 2026 - anioIngreso;
    }

    public double calcularPrestacion() {
        return sueldoBase * 0.03 * getAntiguedad();
    }

    public double calcularHorasExtra() {
        return horasExtra * 276.50;
    }

    public double calcularSueldo() {
        return sueldoBase + calcularPrestacion() + calcularHorasExtra();
    }

    public void mostrarDatos() {
        System.out.println("-----------------------------------------------");
        System.out.println("Numero de trabajador: " + numeroTrabajador);
        System.out.println("Nombre: " + nombres + " " + paterno + " " + materno);
        System.out.println("Horas extra: " + horasExtra);
        System.out.println("Sueldo base: $" + sueldoBase);
        System.out.println("Año de ingreso: " + anioIngreso);
        System.out.println("Antigüedad: " + getAntiguedad() + " años");
        System.out.println("Prestación 3%: $" + calcularPrestacion());
        System.out.println("Pago horas extra: $" + calcularHorasExtra());
        System.out.println("Sueldo a pagar: $" + calcularSueldo());
    }
}