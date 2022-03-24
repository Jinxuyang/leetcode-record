package hot100;

import java.util.HashSet;

/**
 * @Author Verge
 * @Date 2022/3/24 19:23
 * @Version 1.0
 */
public class Code3 {
    public static void main(String[] args) {
        Code3 code3 = new Code3();
        System.out.println(code3.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        char[] chars = s.toCharArray();
        int L = 0, R = 1;
        int res = 0;
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add(chars[0]);
        while (L < R && R < chars.length) {
            if (hashSet.contains(chars[R])) {
                hashSet.remove(chars[L++]);
                if (R - L == 0) {
                    hashSet.add(chars[R++]);
                }
            } else {
                hashSet.add(chars[R++]);
            }
            if (hashSet.size() > res) {
                res = hashSet.size();
            }
        }

        return res;
    }
}
