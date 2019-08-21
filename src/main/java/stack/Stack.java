package stack;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
