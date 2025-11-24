/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

/**
 *
 * @author adria_6
 */
public class ListaEnlazada<T> {
    Nodo<T> head;
    int size;

    public ListaEnlazada() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
    
    public void insert(T data){
        Nodo<T> newNode = new Nodo<>(data);
        if(head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public boolean remove(int index){
        boolean removed = false;
        if(index >= size){
            System.out.println("No se puede eliminar. Indice mayor o igual que el tamaño");
        } else {
            Nodo<T> node = head;
            for(int x=0; x <= index; x++){
                node = node.next;
            }
            
            if (node == head){
                head = head.next;
                removed = true;
            } else {
                node.prev.next = node.next;
                removed = true;
            }
        }
        
        if (removed) size--;
        return removed;
    }
    
    public boolean isEmpty(){
        return size == 0;
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
}
