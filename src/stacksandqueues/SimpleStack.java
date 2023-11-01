package stacksandqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleStack<E> implements PureStack<E> {

    // do any housekeeping before method implementation
    private List<E> internalList;

    public SimpleStack() {
        internalList = new ArrayList<>();
    }

    public SimpleStack(boolean useLinkedList) {
        if (useLinkedList) {
            internalList = new LinkedList<>();
        } else {
            internalList = new ArrayList<>();
        }
    }


    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return internalList.get(0);
        }
        return null;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return internalList.remove(0);
        }
        return null;
    }

    @Override
    public E push(E element) {
        internalList.add(0, element);
        return element;
    }
}
