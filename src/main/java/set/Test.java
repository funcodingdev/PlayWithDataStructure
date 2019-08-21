package set;

/**
 * @Author: FangJu
 * @Date: 2019/8/19
 */
public class Test {
    public static void main(String[] args) {
//        Set<Integer> set = new BSTSet<>();
        Set<Integer> set = new LinkedListSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(1);
        System.out.println(set.getSize());
    }
}
