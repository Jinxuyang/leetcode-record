package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/3/28 20:15
 * @Version 1.0
 */
public class Code62 {
    public static void main(String[] args) {
        Code62 code62 = new Code62();
        System.out.println(code62.uniquePaths(3, 7));
    }

    // 超时
    public int uniquePaths(int m, int n) {
        dfs(m,n,0,0);
        return res;
    }

    int res = 0;
    public void dfs(int m, int n, int y, int x) {
        if (y < 0 || y > m || x < 0 || x > n) return;
        if (y == m - 1 && x == n - 1) {
            res++;
            return;
        }

        dfs(m, n, y+1, x);
        dfs(m, n, y, x + 1);
    }

    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
