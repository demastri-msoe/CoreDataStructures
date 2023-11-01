package stacksandqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DynamicArrayStack<E> implements PureStack<E> {

    // do any housekeeping before method implementation
    private int capacity = 100;
    private int increment = 100;
    private int size = 0;
    private E[] data;

    public DynamicArrayStack(int capacity, int increment) {
        this.capacity = capacity;
        this.increment = increment;
        data = (E[]) new Object[capacity];
    }

    public DynamicArrayStack() {
        data = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return data[size - 1];
        }
        return null;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return data[--size];
        }
        return null;
    }

    @Override
    public E push(E element) {
        if (size == capacity) {
            capacity += increment;
            E[] newData = (E[])new Object[capacity];
            for( int i=0; i<size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size++] = element;
        return element;
    }
}

