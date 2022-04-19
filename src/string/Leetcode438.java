package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/4/19 22:03
 * @Version 1.0
 */
public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        int right = 0, left = 0, valid = 0;
        List<Integer> res = new ArrayList<>();
        while(right < s.length()) {
            char c = s.charAt(right++);

            if(need.containsKey(c)) {
                window.put(c, window.get(c) + 1);
                if(window.get(c).equals(need.get(c))) valid++;
            }

            while(right - left >= p.length()) {
                if(valid == need.size()) {
                    res.add(left);
                }
                char del = s.charAt(left++);
                if(need.containsKey(del)) {
                    if(window.get(del).equals(need.get(del))) valid--;
                    window.put(del, window.get(del) - 1);
                }
            }

        }
        return res;
    }
}
