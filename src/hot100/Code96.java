package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/3/29 16:20
 * @Version 1.0
 */
public class Code96 {
    public static void main(String[] args) {
        Code96 code96 = new Code96();
        System.out.println(code96.numTrees(3));
    }
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n == 1 || n == 0) return 1;
        if (map.containsKey(n)) return map.get(n);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int L = numTrees(i - 1);
            int R = numTrees(n - i);

            cnt += L * R;
        }
        map.put(n, cnt);

        return cnt;
    }



}
