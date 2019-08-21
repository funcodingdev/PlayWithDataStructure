package tree;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(1);
        bst.add(5);
        bst.add(6);
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.levelOrder();
        System.out.println("------------------");
        bst.remove(2);
        bst.levelOrder();
    }
}
