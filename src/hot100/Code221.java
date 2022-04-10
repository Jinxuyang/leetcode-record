package hot100;

/**
 * @Author Verge
 * @Date 2022/4/10 11:31
 * @Version 1.0
 */
public class Code221 {
    public static void main(String[] args) {
        char[][] nums = {{'0','1'},{'1','0'}};
        Code221 code221 = new Code221();
        System.out.println(code221.maximalSquare(nums));
    }
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i = 0;i < matrix.length;i++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for(int i = 0;i < matrix[0].length;i++) {
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
                res = 1;
            }
        }

        for(int i = 1;i < matrix.length;i++) {
            for(int j = 1;j < matrix[0].length;j++) {
                if (matrix[i][j] == '1') {
                    int min = Math.min(dp[i - 1][j - 1], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j]);
                    dp[i][j] = min + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }
}
