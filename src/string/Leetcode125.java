package string;

import java.util.ArrayList;
import java.util.List;

public class Leetcode125 {
    public static void main(String[] args) {
        String s = "a.";
        Leetcode125 leetcode125 = new Leetcode125();
        System.out.println(leetcode125.isPalindrome1(s));
    }

    /**
     * 思路：1. 先处理字符串，去掉除数字和字母的其他字符并统一化为小写
     *      2. 两个指针一个指头一个指尾共同向中间靠近，过程中两个指针指向的字母不同则直接返回false，一直走到完都没返回false就返回true
     */
    public boolean isPalindrome(String s) {
        char[] cs = s.toLowerCase().toCharArray();

        List<Character> list = new ArrayList<>();

        for (char c : cs) {
            if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                list.add(c);
            }
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(list.size() - i - 1)){
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome1(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] cs = s.toLowerCase().toCharArray();
        int x = 0;
        int y = cs.length - 1;
        char front = cs[x];
        char rear = cs[y];
        while (x < y ) {

            if (!((front >= 'a' && front <= 'z') || (front >= '0' && front <= '9'))){

                front = cs[++x];
            } else if (!((rear >= 'a' && rear <= 'z') || (rear >= '0' && rear <= '9'))){
                rear = cs[--y];
            } else {
                if (rear != front){
                    return false;
                }
                front = cs[++x];
                rear = cs[--y];
            }
        }
        return true;
    }


}
