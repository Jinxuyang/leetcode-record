package hot100;

import java.util.Stack;

/**
 * @Author Verge
 * @Date 2022/3/25 21:28
 * @Version 1.0
 */
public class Code20 {
    public static void main(String[] args) {
        Code20 code20 = new Code20();
        System.out.println(code20.isValid("()[]{}"));
    }
    public boolean isValid(String s) {
        if (s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                else {
                    Character temp = stack.pop();
                    if (temp == '(' && c != ')') {
                        return false;
                    } else if (temp == '[' && c != ']') {
                        return false;
                    } else if (temp == '{' && c != '}'){
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
