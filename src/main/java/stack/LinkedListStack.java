package stack;

import linked.LinkedList;

/**
 * @Author: FangJu
 * @Date: 2019/8/19
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E peek() {
        return list.getLast();
    }
}
