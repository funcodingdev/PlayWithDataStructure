package linked;

/**
 * @Author: FangJu
 * @Date: 2019/8/19
 */
public class LinkedList<E> {

    private class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this(value, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = new Node();
        size = 0;
    }

    //获取链表的大小
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在指定的索引位置添加一个元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed! Require index >= 0 && index <= size.");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表头部添加一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表尾部添加一个元素
    public void add(E e) {
        add(size, e);
    }

    //获取指定索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get Failed! Require index >= 0 && index <= size.");
        }
        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //修改指定索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set Failed! Require index >= 0 && index <= size.");
        }
        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.value = e;
    }

    //是否包含此元素
    public boolean contains(E e) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.value.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    //删除指定索引的结点并返回
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove Failed! Require index >= 0 && index <= size.");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.value;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.value.equals(e))
                break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = head.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
