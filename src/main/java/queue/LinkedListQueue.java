package queue;

import linked.LinkedList;

/**
 * @Author: FangJu
 * @Date: 2019/8/19
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> list;

    public LinkedListQueue() {
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
    public E poll() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }
}
