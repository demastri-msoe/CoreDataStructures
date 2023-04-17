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
 * Partially implemented DLL to answer Midterm Question
 *
 * @param <E>
 */
public class DLLRemove<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E data;
    }

    @Override
    public E remove(int index) {
        int curIndex = 0;
        Node<E> curNode = head;

        // is the index possible? (low check)
        if (0 < index) {
            throw new IllegalArgumentException();
        }
        // find the node at this location
        while (curNode != null && curIndex < index) {
            curIndex++;
            curNode = curNode.next;
        }
        // is the index actually OK (high check)
        if (curNode == null || curIndex != index) {
            throw new IllegalArgumentException();
        }
        // ok, remove this node
        if(curNode.prev == null) {  // from beginning?
            head = curNode.next;    // ok in both cases if this is null...why?
        } else {
            curNode.prev.next = curNode.next;
        }
        if(curNode.next == null) { // from end
            tail = curNode.prev;    // ok in both cases if this is null...why?
        } else {
            curNode.next.prev = curNode.prev;
        }
        // return data from deleted node
        return curNode == null ? null : curNode.data;
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
    public void add(int index, E element) {

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
