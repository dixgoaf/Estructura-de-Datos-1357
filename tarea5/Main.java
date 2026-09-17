public class Main {

    // Imprime la lista mostrando cada nodo y a quien apunta.
    public static void imprimirLista(Nodo<String> head) {
        Nodo<String> actual = head;
        int posicion = 1;

        while (actual != null) {
            System.out.println("Posicion " + posicion + ": " + actual);
            actual = actual.getSiguiente();
            posicion++;
        }

        System.out.println();
    }

    // Busca y regresa el ultimo nodo.
    public static Nodo<String> obtenerUltimo(Nodo<String> head) {
        Nodo<String> actual = head;

        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        return actual;
    }

    public static void main(String[] args) {

        // 1. Construccion manual de la lista:
        // head -> Al -> B -> C -> De -> Mc -> Zi -> null

        Nodo<String> head = new Nodo<>("Al");
        Nodo<String> nodoB = new Nodo<>("B");
        Nodo<String> nodoC = new Nodo<>("C");
        Nodo<String> nodoDe = new Nodo<>("De");
        Nodo<String> nodoMc = new Nodo<>("Mc");
        Nodo<String> nodoZi = new Nodo<>("Zi");

        head.setSiguiente(nodoB);
        nodoB.setSiguiente(nodoC);
        nodoC.setSiguiente(nodoDe);
        nodoDe.setSiguiente(nodoMc);
        nodoMc.setSiguiente(nodoZi);

        // 2. Estado inicial completo de la lista.
        System.out.println("========== ESTADO INICIAL ==========");
        imprimirLista(head);

        // 3. Imprimir unicamente el dato del primer nodo.
        System.out.println("Dato del primer nodo: " + head.getDato());
        System.out.println();

        // 4. Imprimir el estado completo del ultimo nodo.
        Nodo<String> ultimo = obtenerUltimo(head);
        System.out.println("Ultimo nodo: " + ultimo);
        System.out.println();

        // 5. Insertar Fe entre De y Mc.
        Nodo<String> nodoFe = new Nodo<>("Fe");

        nodoFe.setSiguiente(nodoDe.getSiguiente());
        nodoDe.setSiguiente(nodoFe);

        System.out.println("========== DESPUES DE INSERTAR Fe ==========");
        imprimirLista(head);

        // 6. Insertar Zz al final.
        Nodo<String> nodoZz = new Nodo<>("Zz");

        ultimo = obtenerUltimo(head);
        ultimo.setSiguiente(nodoZz);

        System.out.println("========== DESPUES DE INSERTAR Zz ==========");
        imprimirLista(head);

        // 7. Insertar Aa al inicio.
        Nodo<String> nodoAa = new Nodo<>("Aa");

        nodoAa.setSiguiente(head);
        head = nodoAa;

        // 8. Estado final.
        System.out.println("========== ESTADO FINAL ==========");
        imprimirLista(head);
    }
}