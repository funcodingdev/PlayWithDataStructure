package array;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class Test {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println(array.toString());
    }
}
