/*
 * Course: CS-2852
 * Spring 2023
 * Core Data Structures Hash Map implementation
 * Name: John DeMastri
 * Created: 05/04/2023
 */
package coredatastructures;

/**
 * Hash Map Interface Implementation
 *
 * @param <K> key type
 * @param <V> value type
 */
public interface JDHashMap<K, V> {
    /**
     * Returns the value associated with the specified key. Returns null if the key is not present
     *
     * @param key to find
     * @return value at that location
     */
    V get(Object key);

    /**
     * Returns true if this table contains no key-value mappings
     *
     * @return T if no mappings exist
     */
    boolean isEmpty();

    /**
     * Returns true if this table contains the specified key
     *
     * @param key to search for
     * @return T if key exists
     */
    boolean contains(K key);

    /**
     * Associates the specified value with the specified key.
     * Returns the previous value associated with the specified key,
     * or null if there was no mapping for the key
     *
     * @param key to place new value
     * @param value to be added
     * @return prior value or null
     */
    V put(K key, V value);

    /**
     * Removes the mapping for this key from this table if it is present (optional operation).
     * Returns the previous value associated with the specified key, or null if there was no mapping
     *
     * @param key to find
     * @return prior value or null
     */
    V remove(Object key);

    /**
     * Returns the size of the table
     *
     * @return the size of the table
     */
    int size();
}
