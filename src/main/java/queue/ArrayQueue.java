package queue;

import array.Array;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> data;

    public ArrayQueue() {
        data = new Array<>();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.add(e);
    }

    @Override
    public E poll() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.get(0);
    }

}
