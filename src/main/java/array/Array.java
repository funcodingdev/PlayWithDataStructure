package array;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class Array<E> {
    private E[] data;
    private int size;

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //获取数组中元素的个数
    public int size() {
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在指定索引位置添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {//索引值小于0或者大于当前容量最大值
            throw new IllegalArgumentException("Add Failed! Require index >= 0 && index <= size.");
        }
        if (size == data.length) {//数组扩容
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {//数组往index后移动一个位置移动
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //添加一个元素至最前
    public void addFirst(E e) {
        add(0, e);
    }

    //添加一个元素至最后
    public void add(E e) {
        add(size, e);
    }

    //获取索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get Failed! Require index >= 0 && index <= size.");
        }
        return data[index];
    }

    //修改索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set Failed! Require index >= 0 && index <= size.");
        }
        data[index] = e;
    }

    //判断数组中是否有此元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //移除索引位置的元素并返回
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove Failed! Require index >= 0 && index <= size.");
        }
        E e = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size] = null;
        size--;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return e;
    }

    //移除第一个元素并返回
    public E removeFirst() {
        return remove(0);
    }

    //移除最后一个元素并返回
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中移除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    //交换两个索引位置的值
    public void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
                .append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
