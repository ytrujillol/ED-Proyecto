// Nodos para almacenar información de cualquier tipo mediante objetos en otras estructuras.
public class Nodo<T> {
    /* Guarda los datos de:
     * - El valor como tipo de dato genérico
     * - El nodo siguiente en la lista enlazada
     * Sigue diagramas UML en informe técnico
     */
    public T value;
    public Nodo<T> next;

    /* Sobrecarga de constructores.
     * Creación de objeto de nodo de diferentes maneras según los argumentos dados.
     */

    // Sólo valor del nodo.
    public Nodo(T value) {
        this.value = this.value;
    }

    // Valor junto con la referencia al siguiente elemento.
    public Nodo(T value, Nodo<T> next) {
        this.value = value;
        this.next = next;
    }
}
