package heap;

import queue.Queue;

/**
 * @Author: FangJu
 * @Date: 2019/8/19
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void push(E e) {
        maxHeap.add(e);
    }

    @Override
    public E poll() {
        return maxHeap.extractMax();
    }

    @Override
    public E peek() {
        return maxHeap.findMax();
    }
}
