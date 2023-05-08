/*
 * Course: CS-2852
 * Spring 2023
 * Core Data Structures Hash Map implementation
 * Name: John DeMastri
 * Created: 05/04/2023
 */
package coredatastructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Hash Map Interface Implementation - Chaining
 *
 * @param <K> key type
 * @param <V> value type
 */
public class HashTableChain<K, V> implements JDHashMap<K, V> {

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

    private static final int CAPACITY = 101;
    private static final int LOAD_THRESHOLD = 3;
    private LinkedList<Entry<K, V>>[] table;
    private int numKeys;

    /**
     * public constructor
     */
    public HashTableChain() {
        table = new LinkedList[CAPACITY];
    }

    private void rehash() {
        // Save a reference to oldTable.
        LinkedList<Entry<K, V>>[] oldTable = table;
        // Double capacity of this table.
        table = new LinkedList[2 * oldTable.length + 1];
        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;

        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                for (Entry<K, V> entry : oldTable[i]) {
                    // Insert entry in expanded table
                    put(entry.key, entry.value);
                }
            }
        }
    }


    /**
     * Method get for class HashtableChain.
     *
     * @param key The key being sought
     * @return The value associated with this key if found;
     * otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // key is not in the table.
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key)) {
                return nextItem.getValue();
            }
        }
        // assert: key is not in the table.
        return null;
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public boolean contains(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] != null) {
            for (Entry<K, V> nextItem : table[index]) {
                if (nextItem.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false; // key is not in the table.
    }

    /**
     * Method put for class HashtableChain.
     * post: This key-value pair is inserted in the
     * table and numKeys is incremented. If the key is already
     * in the table, its value is changed to the argument
     * value and numKeys is not changed.
     *
     * @param key   The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<>();
        }
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.getKey().equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }
        }
        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            rehash();
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;    // not in table
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key != null && e.key.equals(key)) {
                table[index].remove(e);
                numKeys--;
                if (table[index].isEmpty()) {
                    table[index] = null;
                }
                return e.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public String toString() {
        String out = isEmpty() ? ", " : "";
        for (List<Entry<K, V>> l : table) {
            if (l != null) {
                for (HashTableChain.Entry<K, V> e : l) {
                    out += e.toString() + ", ";
                }
            }
        }
        return "[ " + out.substring(0, out.length() - 2) + " ]";
    }
}
