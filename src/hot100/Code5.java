package hot100;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2022/3/24 20:27
 * @Version 1.0
 */
public class Code5 {
    public static void main(String[] args) {
        Code5 code5 = new Code5();
        System.out.println(code5.longestPalindrome1("abcda"));
    }

    boolean flag = false;
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        return get(s, 0, s.length() - 1);
    }

    public String get(String s, int L ,int R){
        if (flag || L > R) {
            return "";
        }
        if (isPalindromic(s, L, R)) {
            return s.substring(L, R + 1);
        }

        String s1 = get(s, L + 1, R);
        String s2 = get(s, L, R - 1);
        return s1.length() > s2.length() ? s1 : s2;
    }

    public boolean isPalindromic(String s, int L ,int R) {
        while (L < R) {
            if (s.charAt(L++) != s.charAt(R--)) return false;
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        if (s.length() == 1) return s;
        int maxLen = -1;
        int begin = -1;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int R = 1; R < s.length(); R++) {
            for (int L = 0; L <= R; L++) {
                if (L == R) {
                    dp[L][R] = true;
                } else if (s.charAt(L) == s.charAt(R)) {
                    if (R - L == 1) dp[L][R] = true;
                    else dp[L][R] = dp[L + 1][R - 1];
                } else {
                    dp[L][R] = false;
                }

                if (dp[L][R] && R - L + 1> maxLen) {
                    maxLen = R - L + 1;
                    begin = L;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
