/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_structures;

/**
 *
 * @author adria_6
 */
public class ListaEnlazada<T> implements LList<T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public ListaEnlazada() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T value) {
        Nodo<T> newNode = new Nodo<>(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T value = tail.value;

        if (head == tail) {          // Solo un elemento
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        Nodo<T> node = nodeAt(index);

        if (node == head) {             // Si el nodo es el primer elemento
            head = head.next;
            if (head != null) head.prev = null;
        } else if (node == tail) {      // Si el nodo es el ultimo elemento
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    @Override
    public void delete(T item) {
        if (isEmpty()) {
            return;
        }

        // Busca la primera occurrencia, si item es null, busca la primera ocurrencia con valor null
        Nodo<T> current = head;
        while (current != null &&
                !(item == null ? current.value == null : item.equals(current.value))) {
            current = current.next;
        }

        if (current == null) {             // no se encuentra el item
            return;
        }

        /* Eliminar ------------------------------------------------------------ */
        if (current == head) {             // el item está en el primer nodo
            head = head.next;
            if (head != null) head.prev = null;
            if (current == tail) tail = head; // Si la lista solo tiene un elemento
        } else if (current == tail) {      // el item está en el ultimo nodo
            tail = tail.prev;
            tail.next = null;
        } else {                           // el item está en un nodo del medio
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return nodeAt(index).value;
    }

    public int find(T data){
        Nodo<T> node = head;
        int c=0;
        while(node != null && !data.equals(node.value)){
            node=node.next;
            c++;
        }
        if(node==null){
            return -1;
        }
        return c;
    }
    private Nodo<T> nodeAt(int index) {
        if (index < (size >> 1)) {           // walk from head
            Nodo<T> current = head;
            for (int i = 0; i < index; i++) current = current.next;
            return current;
        } else {                             // walk from tail
            Nodo<T> current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
            return current;
        }
    }

    /* Validate that index is within [0, size). */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }
}
