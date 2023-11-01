package stacksandqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleQueue<E> implements PureQueue<E> {
    // do any housekeeping before method implementation
    private List<E> internalList;

    public SimpleQueue() {
        internalList = new LinkedList<>();
    }

    public SimpleQueue(boolean useLinkedList) {
        if (useLinkedList) {
            internalList = new LinkedList<>();
        } else {
            internalList = new ArrayList<>();
        }
    }

    @Override
    public boolean offer(E element) {
        try {
            internalList.add(internalList.size(), element);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public E remove() {
        E outElt = poll();
        if (outElt == null) {
            throw new NoSuchElementException("empty queue");
        }
        return outElt;
    }

    @Override
    public E poll() {
        try {
            return internalList.remove(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public E peek() {
        try {
            return internalList.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public E element() {
        E outElt = peek();
        if (outElt == null) {
            throw new NoSuchElementException("empty queue");
        }
        return outElt;
    }
}
