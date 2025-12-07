/* Implementación de montículo usando cualquier objeto genérico
 * Que permite la comparación entre estos con la clase Comparable
 */
package data_structures;

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

    void siftUp(int i);

    void siftDown(int i);

    // Obtener el elemento de mayor prioridad sin eliminarlo del Heap
    T peekMax();

    /* Al insertar o eliminar elementos
     * Se ubican en la altura correcta luego de insertarse en la hoja
     * Según prioridad
     */

    // Comprobaciones del tamaño del montículo
    boolean isEmpty();
    int size();

    // Permitirá eliminar una tutoria especifica
    boolean remove(T tutoria);
}
