/*
 * Course: CS-2852
 * Spring 2023
 * Core Data Structures Hash Map implementation
 * Name: John DeMastri
 * Created: 05/04/2023
 */
package coredatastructures;

/**
 * Hash Map Interface Implementation - Open Addressing
 *
 * @param <K> key type
 * @param <V> value type
 */
public class HashTableOpen<K, V> implements JDHashMap<K, V> {

    /**
     * Contains key-value pairs for a hash table.
     *
     * @param <K> key type
     * @param <V> value type
     */
    private static class Entry<K, V> {

        /**
         * The key
         */
        private final K key;
        /**
         * The value
         */
        private V value;

        /**
         * Creates a new key-value pair.
         *
         * @param key   The key
         * @param value The value
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         *
         * @return The key
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         *
         * @return The value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         *
         * @param val The new value
         * @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        /**
         * Return a string representation of this entry
         *
         * @return "(key, value)"
         */
        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    private static final int START_CAPACITY = 10;
    private static final double LOAD_THRESHOLD = 0.75;
    private final Entry<K, V> DELETED = new Entry<>(null, null);
    private Entry<K, V>[] table;
    private int numKeys;
    private int numDeletes;


    HashTableOpen() {
        table = new Entry[START_CAPACITY];
        numKeys = numDeletes = 0;
    }

    /**
     * Finds either the target key or the first empty slot in the search chain using linear probing.
     * pre: The table is not full.
     *
     * @param key The key of the target object
     * @return The position of the target or the first empty slot if the target is not in the table.
     */
    private int find(Object key) {
        // Calculate the starting index.
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length; // Make it positive.
        }

        // Increment index until an empty slot is reached
        // or the key is found.
        while (table[index] != null && !key.equals(table[index].getKey())) {
            index++;
            // Check for wraparound.
            if (index >= table.length) {
                index = 0; // Wrap around.
            }
        }
        return index;
    }

    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * post: The size of the table is doubled and is an odd integer.
     * Each nondeleted entry from the original table is
     * reinserted into the expanded table.
     * The value of numKeys is reset to the number of items
     * actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        // Save a reference to oldTable.
        Entry<K, V>[] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];
        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && oldTable[i] != DELETED) {
                // Insert entry in expanded table
                put(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }

    @Override
    public V get(Object key) {
        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);
        // If the search is successful, return the value.
        if (table[index] != null) {
            return table[index].getValue();
        }
        return null; // key not found.
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public boolean contains(K key) {
        return table[find(key)] != null;
    }

    @Override
    public V put(K key, V value) {
        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);
        // If an empty element was found, insert new entry.
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            numKeys++;
            // Check whether rehash is needed.
            double loadFactor =
                    (double) (numKeys + numDeletes) / table.length;
            if (loadFactor >= LOAD_THRESHOLD) {
                rehash();
            }
            return null;
        }
        // assert: table element that contains the key was found.
        // Replace value for this key.
        V oldVal = table[index].getValue();
        table[index].setValue(value);
        return oldVal;
    }

    @Override
    public V remove(Object key) {
        int target = find(key);
        if (table[target] == null) {
            return null;
        }
        V oldValue = table[target].getValue();
        table[target] = DELETED;
        numDeletes++;
        numKeys--;
        return oldValue;
    }

    @Override
    public String toString() {
        String out = isEmpty() ? ", " : "";
        for (Entry<K, V> e : table) {
            if (e != null) {
                out += e.toString() + ", ";
            }
        }
        return "[ " + out.substring(0, out.length() - 2) + " ]";
    }

    @Override
    public int size() {
        return numKeys;
    }
}
