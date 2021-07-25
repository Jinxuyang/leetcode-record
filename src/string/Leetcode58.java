package string;

import java.nio.charset.StandardCharsets;

public class Leetcode58 {
    public static void main(String[] args) {
        Leetcode58 leetcode58 = new Leetcode58();

        System.out.println(leetcode58.lengthOfLastWord1("World "));
    }

    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }

    /**
     * 思路： 将字符串转化为字符数组，遍历，遇到空格且不是最后一个字符时，计数器清零，其他情况下每往前移动一格cnt++
     */
    public int lengthOfLastWord1(String s) {
        char[] ca = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == ' '){
                if (i != ca.length - 1) {
                    if (ca[i + 1] != ' ') {
                        cnt = 0;
                    }
                }
            } else if (ca[i] != ' '){
                cnt ++;
            }
        }
        return cnt;
    }
}
