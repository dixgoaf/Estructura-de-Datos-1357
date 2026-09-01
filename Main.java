package tarea2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ADTArray empleados = new ADTArray(100);

String archivo = "tarea2/junio.dat"; 

        try {

            BufferedReader br = new BufferedReader(new FileReader(archivo));

            // Leer encabezado
            br.readLine();

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                int numeroTrabajador = Integer.parseInt(datos[0]);
                String nombres = datos[1];
                String paterno = datos[2];
                String materno = datos[3];
                int horasExtra = Integer.parseInt(datos[4]);
                double sueldoBase = Double.parseDouble(datos[5]);
                int anioIngreso = Integer.parseInt(datos[6]);

                Trabajador trabajador = new Trabajador(
                        numeroTrabajador,
                        nombres,
                        paterno,
                        materno,
                        horasExtra,
                        sueldoBase,
                        anioIngreso
                );

                empleados.agregar(trabajador);
            }

            br.close();

            System.out.println("===============================================");
            System.out.println("       EMPLEADO CON MAYOR ANTIGÜEDAD");
            System.out.println("===============================================");

            Trabajador mayor = empleados.mayorAntiguedad();
            mayor.mostrarDatos();

            System.out.println();
            System.out.println("===============================================");
            System.out.println("       EMPLEADO CON MENOR ANTIGÜEDAD");
            System.out.println("===============================================");

            Trabajador menor = empleados.menorAntiguedad();
            menor.mostrarDatos();

            System.out.println();
            System.out.println("===============================================");
            System.out.println("             TODOS LOS EMPLEADOS");
            System.out.println("===============================================");

            empleados.mostrarTodos();

        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }
    }
}