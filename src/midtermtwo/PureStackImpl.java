package midtermtwo;

import java.util.LinkedList;

public class PureStackImpl<E> implements PureStack<E> {
    private int size;
    private LinkedList<E> data;

    public PureStackImpl() {
        size = 0;
        data = new LinkedList<>();
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return data.get(0);
    }

    @Override
    public E pop() {
        if (size == 0) {
            return null;
        }
        E outData = data.get(0);
        data.remove(0);
        size--;
        return outData;
    }

    @Override
    public void push(E item) {
        data.add(0, item);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
