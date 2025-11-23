public interface MaxHeap<T extends Comparable<T>> {
    void insert(T element);
    T extractMax();
    boolean isEmpty();
    int size();
}
