/*
 * Course: CS-2852
 * Spring 2023
 * Core List Interface
 * Name: John DeMastri
 * Created: 03/22/2023
 */
package coredatastructures;


/**
 * high level interface for our core data structures
 *
 * @param <E> the types that this structure will manage
 */
public interface CoreList<E> {

    /**
     * adds an object to the end of the list.
     * @param elt to be added
     */
    void add(E elt);

    /**
     * removes all elements from the list.
     */
    void clear();

    /**
     * returns true if the specified element is found in the list.
     *
     * @param elt to be found
     * @return true if the element is found
     */
    boolean contains(E elt);

    /**
     * returns the element at the specified location in the list.
     *
     * @param index location in list to search
     * @return elment at that location
     */
    E get(int index);

    /**
     * returns true if no elements are in the list.
     *
     * @return true if no elements are in the list.
     */
    boolean isEmpty();

    /**
     * replaces the element at the specified location with the specified element.
     *
     * @param index location in list to modify
     * @param elt new element to be placed at that location
     * @return the replaced element
     */
    E set(int index, E elt);

    /**
     * returns the number of elements in the list.
     *
     * @return the number of elements in the list.
     */
    int size();
}
