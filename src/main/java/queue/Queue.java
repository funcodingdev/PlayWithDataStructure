package queue;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E poll();

    E peek();
}
