package data_structures;
import java.util.ArrayList;

public class ArrayMaxHeap<T extends Comparable<T>> implements MaxHeap<T>{
    private ArrayList<T> heap;
    
    public ArrayMaxHeap(){
        heap = new ArrayList<>();
    }
    
    @Override 
    public void insert(T element){
        heap.add(element);
        siftUp(size()-1);
    }
    
    @Override
    public T extractMax(){
        if (isEmpty()){
            return null;
        }
        
        T max = heap.get(0);
        T last = heap.remove(size()-1);
        
        if(!isEmpty()){
            heap.set(0,last);
            siftDown(0);
        }
        return max;
    }

    @Override
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    
    @Override
    public int size(){
        return heap.size();
    }
    
    private int getParent(int i){
        return (i-1)/2;
    }
    private int getLeftChild(int i){
        return 2*i+1;
    }
    private int getRightChild(int i){
        return 2*i+2;
    }

    private void swap(int i, int j){
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,temp);
    }

    @Override
    public void siftUp(int i){
        while(i>0){
            int parent = getParent(i);
            if (heap.get(i).compareTo(heap.get(parent)) <= 0){
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    @Override
    public void siftDown(int i){
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int maxIndex = i;
        
        if(left < size() && heap.get(left).compareTo(heap.get(maxIndex)) > 0){
            maxIndex = left;
        }
        
        if(right < size() && heap.get(right).compareTo(heap.get(maxIndex)) > 0){
            maxIndex = right;
        }
        
        if (i != maxIndex){
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }
    
    private void changePriority(int i, T newPriority){
        //Por implementar
    }

    @Override
    public T peekMax(){
        if (isEmpty()){
            return null;
        }
        return heap.get(0);
    }

}