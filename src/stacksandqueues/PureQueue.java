package stacksandqueues;

public interface PureQueue<E> {
    // inserts at rear of queue
    boolean offer(E element);

    // remove from front of queue - NoSuchElementException if empty
    E remove();

    // remove from front of queue - null if empty
    E poll();

    // returns entry at front of queue - does not remove - null if empty
    E peek();

    // returns entry at front of queue - does not remove - NoSuchElementException if empty
    E element();
}
