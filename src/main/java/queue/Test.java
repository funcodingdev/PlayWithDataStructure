package queue;

/**
 * @Author: FangJu
 * @Date: 2019/8/18
 */
public class Test {
    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayQueue<>();
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
