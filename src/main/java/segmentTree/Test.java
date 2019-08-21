package segmentTree;

/**
 * @Author: FangJu
 * @Date: 2019/8/21
 */
public class Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2,3,4,5,6,7,8,9,10,11,12,13};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, ((left, right) -> left + right));
        System.out.println(segmentTree.query(1,6));
    }
}
