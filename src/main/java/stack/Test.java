package stack;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
//        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
