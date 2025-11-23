public class Nodo<T> {
    public T value;
    public Nodo<T> next;
    public Nodo<T> prev;

    public Nodo(T value) {
        this.value = this.value;
    }

    public Nodo(T value, Nodo<T> next, Nodo<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
