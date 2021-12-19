package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2021/12/19 17:37
 * @Version 1.0
 */
public class Leetcode997 {
    public int findJudge(int n, int[][] trust) {
        if (n == 0) return -1;
        if (n == 1) return 1;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            int key = trust[i][1];
            if (map.containsKey(key)) {
                int val = map.get(key) + 1;
                map.put(key, val);
            } else {
                map.put(key, 1);
            }
        }

        int res = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key) == n - 1) {
                boolean flag = true;
                for (int i = 0; i < trust.length; i++) {
                    if (trust[i][0] == key) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = key;
                    break;
                }
            }

        }

        return res;

    }

}
