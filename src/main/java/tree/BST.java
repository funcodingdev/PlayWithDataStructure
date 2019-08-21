package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树
 *
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E value;
        Node left;
        Node right;

        public Node(E value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e,不包含重复元素
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    //向根中添加结点
    private void add(Node root, E e) {
        if (e.equals(root.value)) {
            return;
        } else if (e.compareTo(root.value) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(root.value) > 0 && root.right == null) {
            root.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(root.value) < 0) {
            add(root.left, e);
        } else {
            add(root.right, e);
        }
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null || e == null) {
            return false;
        }
        if (e.compareTo(root.value) == 0) {
            return true;
        } else if (e.compareTo(root.value) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    //二叉搜索树前序遍历的非递归形式
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二叉搜索树的层序遍历（广度优先遍历）
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    //二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }


    //二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.value);
    }

    //返回最小值
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).value;
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return minimum(root.left);
        }
    }

    //返回最大值
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).value;
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root;
        } else {
            return maximum(root.right);
        }
    }

    //从二叉搜索树中删除最小结点，并返回
    public E removeMin() {
        E res = minimum();
        root = removeMin(root);
        return res;
    }

    //删除最小结点并返回根结点
    private Node removeMin(Node root) {
        if (root.left == null) {
            Node rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;
        }
        root.left = removeMin(root.left);
        return root;
    }

    public E removeMax() {
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    private Node removeMax(Node root) {
        if (root.right == null) {
            Node leftNode = root.left;
            root.left = null;
            size--;
            return leftNode;
        }
        root.right = removeMax(root.right);
        return root;
    }

    //删除二叉搜索树的指定结点
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node root, E e) {
        if (root == null) {
            return null;
        }
        if (root.value.compareTo(e) > 0) {//e < root.value
            root.left = remove(root.left, e);
            return root;
        } else if (root.value.compareTo(e) < 0) {//e > root.value
            root.right = remove(root.right, e);
            return root;
        } else {//e = root.value
            if (root.left == null) {
                Node rightNode = root.right;
                root.right = null;
                size--;
                return rightNode;
            }
            if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;
                size--;
                return leftNode;
            }
            Node rightMinNode = minimum(root.right);//root的后继结点，即为root右子树的最小值
            rightMinNode.right = removeMin(root.right);//新结点的右子树指向新树
            rightMinNode.left = root.left;//新结点的左子树指向原来root的左子树
            root.left = root.right = null;//原来root的左右子树指向为null
            return rightMinNode;
        }
    }
}
