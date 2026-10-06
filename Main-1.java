public class Main {
  public static void main(String[] args) {
    ListaLigada<Integer> lista = new ListaLigada<>();

    System.out.println("Vacia? " + lista.esta_vacia());
    lista.Agregar(10);
    lista.agregar_al_final(20);
    lista.agregar_al_inicio(5);
    lista.agregar_despues_de(10, 15);
    lista.transversal(); // 5 -> 10 -> 15 -> 20 -> null
    System.out.println("Longitud: " + lista.get_longitud());

    System.out.println("Buscar 15 esta en: " + lista.buscar(15));
    lista.actualizar(15, 17);
    lista.transversal();

    lista.eliminar_el_primero();
    lista.transversal();
    lista.eliminar_el_final();
    lista.transversal();
    System.out.println("Longitud final: " + lista.get_longitud());

    System.out.println("\n--- Lista de helados ---");
    ListaLigada<Helado> helados = new ListaLigada<>();

    System.out.println("Vacia? " + helados.esta_vacia());
    helados.Agregar(new Helado("Vainilla", 2, 35.50));
    helados.agregar_al_final(new Helado("Chocolate", 1, 40.00));
    helados.agregar_al_inicio(new Helado("Fresa", 3, 30.00));
    helados.agregar_despues_de(new Helado("Vainilla", 2, 35.50), new Helado("Menta", 1, 45.00));
    helados.transversal();
    System.out.println("Longitud: " + helados.get_longitud());

    System.out.println("Buscar Chocolate esta en: " + helados.buscar(new Helado("Chocolate", 1, 40.00)));
    helados.actualizar(new Helado("Menta", 1, 45.00), new Helado("Menta", 2, 42.50));
    helados.transversal();

    helados.eliminar_el_primero();
    helados.transversal();
    helados.eliminar_el_final();
    helados.transversal();
    System.out.println("Longitud final: " + helados.get_longitud());
  }
}
