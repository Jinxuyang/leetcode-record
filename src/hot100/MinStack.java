package hot100;

import java.util.Stack;

/**
 * @Author Verge
 * @Date 2022/4/5 13:19
 * @Version 1.0
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> helper;
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        int min;
        if (!helper.empty()) {
            min = Math.min(val, helper.peek());
        } else {
            min = val;
        }
        helper.push(min);
    }

    public void pop() {
        if (!helper.empty() && !stack.empty()) {
            stack.pop();
            helper.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
