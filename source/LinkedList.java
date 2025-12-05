package source;

// Interfaz de Lista Enlazada
// Uso de objetos genéricos para manejar los distintos tipos de objetos
public interface LinkedList<T> {

    // Lista enlazada simple con adición de datos al final
    void insert(T value);

    // Eliminación sólo al final de la lista
    T pop();

    // Eliminación por índice
    void remove(int index);

    // Eliminación de objeto
    void delete(T item);

    // Obtener elemento deseado dado un índice que marca la posición
    T get(int index);

    // Comprobación de la cantidad de elementos de la lista
    int size();

    // Revisión del estado de la lista enlazada
    boolean isEmpty();
}
