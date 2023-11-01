package stacksandqueues;

public interface PureStack<E> {
    // returns true if stack is empty, else false
    boolean isEmpty();
    // returns entry at front of stack - does not remove - null if empty
    E peek();
    // returns entry at front of stack and removes it - null if empty
    E pop();
    // pushes an item onto the stack - returns item pushed
    E push(E element);
}
