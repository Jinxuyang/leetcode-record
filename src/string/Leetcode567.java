package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/4/19 21:21
 * @Version 1.0
 */
public class Leetcode567 {
    public static void main(String[] args) {
        Leetcode567 leetcode567 = new Leetcode567();
        System.out.println(leetcode567.checkInclusion("axae", "aeax"));
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        int right = 0, left = 0, valid = 0;
        while(right < s2.length()) {
            char c = s2.charAt(right++);

            if(need.containsKey(c)) {
                window.put(c, window.get(c) + 1);
                if(window.get(c).equals(need.get(c))) valid++;
            }

            while(right - left >= s1.length()) {
                if(valid == need.size()) return true;
                char del = s2.charAt(left++);
                if(need.containsKey(del)) {
                    if(window.get(del).equals(need.get(del))) valid--;
                    window.put(del, window.get(del) - 1);
                }
            }
        }
        return false;
    }
}
