public class ListaLigada<T> {

  private Nodo<T> head;
  private int longitud;

  // ListaLigada(): Constructor que inicializa una lista vacia.
  public ListaLigada() {
    this.head = null;
    this.longitud = 0;
  }

  // esta_vacia(): True si no hay elementos, False en caso contrario.
  public boolean esta_vacia() {
    return head == null;
  }

  // get_longitud(): numero total de elementos actuales.
  public int get_longitud() {
    return longitud;
  }

  // Agregar(valor): agrega un nodo al final de la lista.
  public void Agregar(T valor) {
    agregar_al_final(valor);
  }

  // agregar_al_final(valor): recorre desde head e inserta al final.
  public void agregar_al_final(T valor) {
    Nodo<T> nuevo = new Nodo<>(valor);
    if (esta_vacia()) {
      head = nuevo;
    } else {
      Nodo<T> actual = head;
      while (actual.getSiguiente() != null) {
        actual = actual.getSiguiente();
      }
      actual.setSiguiente(nuevo);
    }
    longitud++;
  }

  // agregar_al_inicio(valor): el nuevo nodo se vuelve el head.
  public void agregar_al_inicio(T valor) {
    Nodo<T> nuevo = new Nodo<>(valor);
    nuevo.setSiguiente(head);
    head = nuevo;
    longitud++;
  }

  // agregar_despues_de(referencia, valor): inserta despues de la primer
  // coincidencia.
  public void agregar_despues_de(T referencia, T valor) {
    Nodo<T> actual = head;
    while (actual != null) {
      boolean coincide = (referencia == null) ? actual.getDato() == null : referencia.equals(actual.getDato());
      if (coincide) {
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        longitud++;
        return;
      }
      actual = actual.getSiguiente();
    }
    System.out.println("Referencia \"" + referencia + "\" no encontrada, no se inserto.");
  }

  // eliminar_el_primero(): remueve el nodo inicial (head).
  public void eliminar_el_primero() {
    if (esta_vacia()) {
      System.out.println("La lista esta vacia, no hay nada que eliminar.");
      return;
    }
    head = head.getSiguiente();
    longitud--;
  }

  // eliminar_el_final(): remueve el ultimo nodo.
  public void eliminar_el_final() {
    if (esta_vacia()) {
      System.out.println("La lista esta vacia, no hay nada que eliminar.");
      return;
    }
    if (head.getSiguiente() == null) {
      head = null;
    } else {
      Nodo<T> actual = head;
      while (actual.getSiguiente().getSiguiente() != null) {
        actual = actual.getSiguiente();
      }
      actual.setSiguiente(null);
    }
    longitud--;
  }

  // buscar(valor): regresa el indice de la primera coincidencia o -1 si no
  // existe.
  public int buscar(T valor) {
    Nodo<T> actual = head;
    int indice = 0;
    while (actual != null) {
      boolean coincide = (valor == null) ? actual.getDato() == null : valor.equals(actual.getDato());
      if (coincide) {
        return indice;
      }
      actual = actual.getSiguiente();
      indice++;
    }
    return -1;
  }

  // actualizar(a_buscar, valor): reemplaza la primera coincidencia. Regresa true
  // si lo logro.
  public boolean actualizar(T a_buscar, T valor) {
    Nodo<T> actual = head;
    while (actual != null) {
      boolean coincide = (a_buscar == null) ? actual.getDato() == null : a_buscar.equals(actual.getDato());
      if (coincide) {
        actual.setDato(valor);
        return true;
      }
      actual = actual.getSiguiente();
    }
    System.out.println("Elemento \"" + a_buscar + "\" no encontrado, no se actualizo.");
    return false;
  }

  // transversal(): recorrido secuencial que muestra todos los elementos.
  public void transversal() {
    if (esta_vacia()) {
      System.out.println("Lista vacia.");
      return;
    }
    Nodo<T> actual = head;
    StringBuilder sb = new StringBuilder();
    while (actual != null) {
      sb.append(actual.getDato());
      if (actual.getSiguiente() != null) {
        sb.append(" -> ");
      }
      actual = actual.getSiguiente();
    }
    sb.append(" -> null");
    System.out.println(sb.toString());
  }
}
