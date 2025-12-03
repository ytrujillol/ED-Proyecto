package source;

// Nodos para almacenar información de cualquier tipo mediante objetos en otras estructuras.
public class Nodo<T> {
    /* Guarda los datos de:
     * - El valor como tipo de dato genérico
     * - El nodo siguiente y anterior en la lista enlazada
     * Sigue diagramas UML en informe técnico
     */
    public T value;
    public Nodo<T> next;
    public Nodo<T> prev;

    /* Sobrecarga de constructores.
     * Creación de objeto de nodo de diferentes maneras según los argumentos dados.
     */

    // Sólo valor del nodo.
    public Nodo(T value) {
        this.value = value;
    }

    // Valor junto con la referencia al siguiente elemento.
    public Nodo(T value, Nodo<T> next,  Nodo<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
