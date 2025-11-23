public interface MaxHeap<T extends Comparable<T>> {
    // Método para agregar elementos al Heap
    void insert(T element);

    // Método para obtener el elemento de mayor prioridad, extrayéndolo del Heap
    T extractMax();

    // Comprobaciones del tamaño del montículo
    boolean isEmpty();
    int size();
}
