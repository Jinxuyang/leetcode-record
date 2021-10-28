package queue;

import java.util.Stack;

/**
 * @Author Verge
 * @Date 2021/10/28 19:50
 * @Version 1.0
 */
public class JZOffer09 {
    public static void main(String[] args) {
        JZOffer09 jzOffer09 = new JZOffer09();
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());


    }

    /**
     * 思路：堆栈的特性时先进后出，队列的特点是先进先出
     *      我们可以将所有数字入栈1，当我们需要出队时，将栈1内的所有数字依次出栈，并入栈2，这时栈2内的数字相对于栈1就是倒序的
     *      出队就从就从栈2出栈，当栈2为空时首先考虑栈1内是否有元素，就执行上面的操作，没有则说明真的没有元素了
     */
    static class CQueue {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                if (stack2.empty()) return -1;
            }
            return stack2.pop();
        }
    }
}
