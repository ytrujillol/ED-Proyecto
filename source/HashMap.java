package source;

/**
 *
 *
 * @author adria_6
 */
public class HashMap<K, V> implements Map<K, V> {

    /* -----------------------------  constantes  -------------------------- */
    private static final int   DEFAULT_CAPACITY  = 16;     // de la forma 2^n
    private static final float LOAD_FACTOR       = 0.75f;  // para decidir cuando hacer rezise

    /* -----------------------------  clase Entry  ------------------------- */
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key   = key;
            this.value = value;
            this.next  = next;
        }
    }

    /* -----------------------------  atributos  ----------------------------- */
    private Entry<K, V>[] table;   // bucket array
    private int size;              // numero de parejas
    private int threshold;         // resize cuando size >= threshold

    /* -----------------------------  constructor  ------------------------ */
    @SuppressWarnings("unchecked")
    public HashMap() {
        table      = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        threshold  = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
        size       = 0;
    }

    /* ===========================  Metodos  ============================ */

    /** Asocia key con value. */
    @Override
    public void put(K key, V value) {
        int idx = bucketIndex(key);

        // Verificar si key ya existe en el arreglo -------------------
        for (Entry<K, V> e = table[idx]; e != null; e = e.next) {
            if (equalsKey(key, e.key)) {
                e.value = value;  // update
                return;
            }
        }

        // Inserta nueva entrada en head -------
        table[idx] = new Entry<>(key, value, table[idx]);
        size++;

        // Resize si es necesario --------------------------------------------
        if (size >= threshold) {
            resize();
        }
    }

    /** Devuelve el valor mapeado a key, o null si el valor no está presente */
    @Override
    public V get(K key) {
        Entry<K, V> e = findEntry(key);
        return e == null ? null : e.value;
    }

    /** Devuelve verdadero si el map contiene key. */
    @Override
    public boolean find(K key) {
        return findEntry(key) != null;
    }

    /** Elimina key y su valor del mapa. Devuleve verdadero si se eliminó correctamente*/
    @Override
    public boolean remove(K key) {
        int idx = bucketIndex(key);
        Entry<K, V> prev = null;
        Entry<K, V> curr = table[idx];

        while (curr != null) {
            if (equalsKey(key, curr.key)) {
                if (prev == null) {                // first node in bucket
                    table[idx] = curr.next;
                } else {                           // middle / last node
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;  // not found
    }

    /** Devuelve el número de parejas. */
    @Override
    public int getSize() {
        return size;
    }

    /* =========================  private helpers  ======================== */

    /** Devuelve la Entry asociada a key. Null si no existe */
    private Entry<K, V> findEntry(K key) {
        for (Entry<K, V> e = table[bucketIndex(key)]; e != null; e = e.next) {
            if (equalsKey(key, e.key)) {
                return e;
            }
        }
        return null;
    }

    /** Compute bucket index for a key (null key goes to bucket 0). */
    private int bucketIndex(K key) {
        if (key == null) return 0;
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    /** Key equality helper that also handles nulls. */
    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || (k1 != null && k1.equals(k2));
    }

    /** duplica la capacidad y hace rehash de todas las parejas actuales*/
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCap = table.length * 2;
        Entry<K, V>[] oldTable = table;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCap];

        // Re-insert todas las entradas en la nueva tabla -----------------------
        for (Entry<K, V> head : oldTable) {
            while (head != null) {
                Entry<K, V> next = head.next;

                int idx = (head.key == null)
                        ? 0
                        : (head.key.hashCode() & 0x7fffffff) % newCap;

                head.next = newTable[idx];
                newTable[idx] = head;

                head = next;
            }
        }

        table     = newTable;
        threshold = (int) (newCap * LOAD_FACTOR);
    }
}