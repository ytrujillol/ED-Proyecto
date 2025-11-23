/* Implementación de montículo usando cualquier objeto genérico
 * Que permite la comparación entre estos con la clase Comparable
 */

public interface MaxHeap<T extends Comparable<T>> {
    /* Se insertan elementos en el heap de cualquier clase
     * Se hace uso de arbol, se insertan en las hojas
     */
    void insert(T element);

    /* Metodo para obtener el elemento de mayor prioridad, extrayéndolo del Heap
     * Permite procesar los elementos de mayor prioridad
     * Aplica para el caso de las tutorías según la prioridad
     */
    T extractMax();

    // Obtener el elemento de mayor prioridad sin eliminarlo del Heap
    T peekMax();

    /* Al insertar o eliminar elementos
     * Se ubican en la altura correcta luego de insertarse en la hoja
     * Según prioridad
     */
    void SiftDown(T element);
    void SiftUp(T element);

    // Comprobaciones del tamaño del montículo
    boolean isEmpty();
    int size();
}
