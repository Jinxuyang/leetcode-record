package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/4/19 20:35
 * @Version 1.0
 */
public class Code76 {
    public static void main(String[] args) {
        Code76 code76 = new Code76();
        System.out.println(code76.minWindow("ADOBECODEBANC", "ABC"));
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c : t.toCharArray())  {
            window.put(c, 0);
            if(need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()) {
            char c = s.charAt(right++);
            if(need.containsKey(c)) {
                window.put(c, window.get(c) + 1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while(valid == need.size()) {
                if(right - left <= len) {
                    start = left;
                    len = right - left;
                }

                char del = s.charAt(left++);
                if(need.containsKey(del)) {
                    if(window.get(del).equals(need.get(del))) valid--;
                    window.put(del, window.get(del) - 1);
                }
            }
        }

        if(len == Integer.MAX_VALUE) return "";
        else return s.substring(start, start + len);
    }
}
