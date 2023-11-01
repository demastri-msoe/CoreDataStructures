package stacksandqueues;

import java.util.NoSuchElementException;

public class CircularQueue<E> implements PureQueue<E> {
    private int capacity = 100;
    private int increment = 100;
    private int size = 0;
    private E[] data;
    private int front = 0;  // points to the next element to be removed
    private int rear = -1;  // points to the last element added

    public CircularQueue(int capacity, int increment) {
        this.capacity = capacity;
        this.increment = increment;
        data = (E[]) new Object[capacity];
    }

    public CircularQueue() {
        data = (E[]) new Object[capacity];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean offer(E element) {
        return offer1(element);
        //return offer2(element);
    }
    private boolean offer1(E element) {
        if (capacity == size) {
            capacity += increment;
            E[] newData = (E[]) new Object[capacity];
            int oldSize = size;
            for (int i = 0; i < oldSize; i++) {
                newData[i] = poll();    // this "rebases" the queue to start from 0
            }
            data = newData;
            rear = oldSize-1;
            front = 0;
            size = oldSize;
        }
        rear = (rear + 1) % capacity;
        data[rear] = element;
        size++;
        return true;
    }

    private boolean offer2(E element) {
        if (capacity == size) {
            E[] newData = (E[]) new Object[capacity + increment];
            for (int i = 0; i < size; i++) {
                int eltPosition = (front+i) % capacity;
                newData[i] = data[eltPosition];    // this "rebases" the queue to start from 0
            }
            capacity += increment;
            data = newData;
            rear = size-1;
            front = 0;
        }
        rear = (rear + 1) % capacity;
        data[rear] = element;
        size++;
        return true;
    }


    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return poll();
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E outElt = data[front];
        front = (front + 1) % capacity;
        size--;
        return outElt;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return peek();
    }
}
