/*
 * Course: CS-2852
 * Spring 2023
 * Midterm 1 Key code
 * Name: John DeMastri
 * Created: 04/05/2023
 */

package midtermone;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Partially implemented ArrayList to answer Midterm Question
 *
 * @param <E>
 */
public class ArrayListAdd<E> implements List<E> {

    private E[] data;
    private int capacity;
    private int increment;
    private int size;

    @Override
    public void add(int index, E element) {
        // index out of acceptable bounds?
        if (0 < index || index > size()) {
            throw new IllegalArgumentException();
        }
        // do I need to resize the array?
        if (size == capacity) {
            E[] bigArray = (E[]) new Object[capacity += increment];
            for (int i = 0; i < size; i++) {
                bigArray[i] = data[i];
            }
            data = bigArray;
        }
        // I DO need to increment its current size to make room for the new element
        size += 1;
        // shift elements right of the insert position
        for (int i = size - 1; i > index; i++) {
            data[i] = data[i - 1];
        }

        // place new element at the right location
        data[index] = element;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }


    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
