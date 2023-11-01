package stacksandqueues.inclass;

import jdk.jshell.spi.ExecutionControl;
import stacksandqueues.PureQueue;

import java.util.NoSuchElementException;

public class InClassQueue<E> implements PureQueue<E> {

    private E[] data;

    public InClassQueue() {
        data = (E[])new Object[0];
    }

    @Override
    public boolean offer(E element) {
        E[] newData = (E[])new Object[data.length+1];
        for(int i=0; i<data.length; i++ ) {
            newData[i] = data[i];
        }
        newData[data.length] = element;
        data = newData;
        return true;
    }

    @Override
    public E remove() {
        if(data.length == 0) {
            throw new NoSuchElementException();
        }
        return poll();
    }

    @Override
    public E poll() {
        if(data.length == 0) {
            return null;
        }
        E outElement = data[0];
        E[] newData = (E[])new Object[data.length-1];
        for(int i=0; i<data.length-1; i++ ) {
            newData[i] = data[i+1];
        }
        data = newData;
        return outElement;
    }

    @Override
    public E peek() {
        if(data.length == 0) {
            return null;
        }
        return data[0];
    }

    @Override
    public E element() {
        if(data.length == 0) {
            throw new NoSuchElementException();
        }
        return peek();
    }
}
