package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Verge
 * @Date 2022/1/28 15:31
 * @Version 1.0
 */
public class JZOffer30 {

}

class MinStack {
    Stack<Integer> stackA;
    Stack<Integer> stackB;

    /** initialize your data structure here. */
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {

        stackA.push(x);
        if (stackB.isEmpty()) {
            stackB.push(x);
        } else {
            int temp = stackB.peek();
            stackB.push(Math.min(temp, x));
        }
    }

    public void pop() {
        stackA.pop();
        stackB.pop();
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}
