package array;

/**
 * @Author Verge
 * @Date 2022/4/20 12:43
 * @Version 1.0
 */
public class Leetcode344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
