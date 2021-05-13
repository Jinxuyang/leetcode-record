package string;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/5/13 20:44
 * @Version 1.0
 */
public class Leetcode344 {
    public static void main(String[] args) {
        char[] c = {'h', 'e', 'l', 'l'};
        reverseString(c);
        System.out.println(c);
    }
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}