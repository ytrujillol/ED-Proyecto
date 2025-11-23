// Nodos para almacenar información de cualquier tipo mediante objetos en otras estructuras.
public class Nodo<T> {
    public T value;
    public Nodo<T> next;
    public Nodo<T> prev;

    // Sobrecarga de constructores
    public Nodo(T value) {
        this.value = this.value;
    }

    public Nodo(T value, Nodo<T> next, Nodo<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
