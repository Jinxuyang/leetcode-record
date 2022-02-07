package other;

import java.util.Stack;

/**
 * @Author Verge
 * @Date 2022/1/30 13:11
 * @Version 1.0
 */
public class JZOffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 || popped.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        stack.push(pushed[i]);
        while (true) {
            if (stack.isEmpty() || stack.peek() != popped[j]) {
                i++;
                if (i > pushed.length - 1) return false;
                stack.push(pushed[i]);
            } else {
                stack.pop();
                j++;
                if (j > popped.length - 1) return true;
            }
        }
    }
}
