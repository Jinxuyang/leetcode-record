package hot100;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/4/3 13:32
 * @Version 1.0
 */
public class Code139 {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        Code139 code139 = new Code139();
        System.out.println(code139.wordBreak1(s, list));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return get(s, 0, wordDict);
    }
    Map<String, Boolean> map = new HashMap<>();
    public boolean get(String s, int index, List<String> workDict) {
        if (index >= s.length()) return true;

        if (map.containsKey(s.substring(index))) return map.get(s.substring(index));
        for (String dict : workDict) {
            if (s.startsWith(dict, index)) {
                boolean res = get(s, index + dict.length(), workDict);
                if (res) {
                    map.put(s.substring(index), true);
                    return true;
                }
            }
        }
        map.put(s.substring(index), false);
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (String dict : wordDict) {
                if (s.startsWith(dict, i) && !dp[i + dict.length()]) dp[i + dict.length()] = dp[i];
            }
        }

        return dp[dp.length - 1];
    }
}
