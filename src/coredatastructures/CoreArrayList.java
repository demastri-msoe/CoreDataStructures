/*
 * Course: CS-2852
 * Spring 2023
 * Core Array List Implementation
 * Name: John DeMastri
 * Created: 03/22/2023
 */

package coredatastructures;

/**
 * Array-based instantiation of CoreList<>
 *
 * @param <E> type being managed in this list
 */
public class CoreArrayList<E> implements CoreList<E> {
    private static final int DEFAULT_INCREMENT = 10;
    private E[] data;
    private int increment;
    private int capacity;
    private int size;

    /**
     * default constructor, initializes data
     */
    public CoreArrayList() {
        data = (E[]) new Object[capacity = increment = DEFAULT_INCREMENT];
        size = 0;
    }

    /**
     * constructor allowing modification of increment, initializes data
     *
     * @param increment increment to use
     */
    public CoreArrayList(int increment) {
        data = (E[]) new Object[capacity = this.increment = increment];
    }

    /**
     * constructor allowing modification of increment and capacity
     * initializes data
     *
     * @param capacity  initial capacity
     * @param increment increment to use
     */
    public CoreArrayList(int capacity, int increment) {
        this.increment = increment;
        data = (E[]) new Object[this.capacity = capacity];
    }


    @Override
    public void add(E elt) {
        if (size() == capacity) {
            E[] newData = (E[]) new Object[capacity += increment];
            for (int i = 0; i < size(); i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[++size] = elt;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(E elt) {
        for (E heldElt : data) {
            if (elt == heldElt || elt != null && elt.equals(heldElt)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (!validateIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E set(int index, E elt) {
        if (!validateIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        E outVal = data[index];
        data[index] = elt;
        return outVal;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * helper method to check if provided index is ok
     *
     * @param index value to check
     */
    private boolean validateIndex(int index) {
        return !(index >= size() || index < 0);
    }
}
