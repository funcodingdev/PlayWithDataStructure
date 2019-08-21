package stack;

import array.Array;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    public ArrayStack() {
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
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.get(data.size() - 1);
    }
}
