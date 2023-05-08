package midtermtwo;

public interface PureStack<E> {
    public E peek();

    public E pop();

    public void push(E item);

    public int size();

    public boolean isEmpty();
};
