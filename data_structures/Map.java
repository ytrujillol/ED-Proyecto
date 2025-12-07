/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data_structures;

/**
 *
 * @author adria_6
 */
public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    boolean find(K key);
    boolean remove(K key);
    int getSize();
}
