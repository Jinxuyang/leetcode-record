package hot100;

/**
 * @Author Verge
 * @Date 2022/3/28 21:02
 * @Version 1.0
 */
public class Code64 {
    public static void main(String[] args) {
        Code64 code64 = new Code64();
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(code64.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < grid[0].length; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0) continue;
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
