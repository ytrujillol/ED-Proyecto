package data_structures;

import java.util.ArrayList;
import modules.*;

public class ArrayMaxHeap implements MaxHeap<Tutoria>{
    private final ArrayList<Tutoria> heap;
    
    public ArrayMaxHeap(){
        heap = new ArrayList<>();
    }
    
    @Override 
    public void insert(Tutoria element){
        heap.add(element);
        siftUp(size()-1);
    }
    
    @Override
    public Tutoria extractMax(){
        if (isEmpty()){
            return null;
        }
        
        Tutoria max = heap.get(0);
        Tutoria last = heap.remove(size()-1);
        
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
        Tutoria temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,temp);
    }
    
    public void siftUp(int i){
        while(i>0){
            int parent = getParent(i);
            if (heap.get(i).getPrioridad() <= heap.get(parent).getPrioridad()){
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    public void siftDown(int i){
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int maxIndex = i;
        
        if(left < size() && heap.get(left).getPrioridad() > heap.get(maxIndex).getPrioridad()){
            maxIndex = left;
        }
        
        if(right < size() && heap.get(right).getPrioridad() > heap.get(maxIndex).getPrioridad()){
            maxIndex = right;
        }
        
        if (i != maxIndex){
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }
    
    private void changePriority(int i, int nuevaPrioridad) {
    
        int viejaPrioridad = heap.get(i).getPrioridad();
        heap.get(i).setPrioridad(nuevaPrioridad);
        if (nuevaPrioridad > viejaPrioridad) {
            siftUp(i);
        }
        else {
            siftDown(i);
        }
    }
    
    public Tutoria peekMax(){
        if (isEmpty()){
            return null;
        }
        return heap.get(0);
    }
    
    public boolean remove (Tutoria t){
        Tutoria eliminado = null;
        
        for (int i=0; i<size(); i++){
            Tutoria actual = heap.get(i);
            if (t.getIdTutoria() == actual.getIdTutoria()){
                changePriority(i, Integer.MAX_VALUE);
                eliminado = extractMax();
                break;
            }
        }
        return eliminado != null;
    }    
}