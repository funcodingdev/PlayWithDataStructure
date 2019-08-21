package heap;

import array.Array;

/**
 * @Author: FangJu
 * @Date: 2019/8/19
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("No Parent!");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(size() - 1);
    }

    //元素上浮
    private void siftUp(int k) {
        while (k > 0 && (data.get(k).compareTo(data.get(parent(k))) > 0)) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax() {
        if (data.size() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax() {

        E ret = findMax();

        data.swap(0, data.size() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    //元素下沉
    private void siftDown(int k) {
        while (leftChild(k) < data.size()) {
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < data.size() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
