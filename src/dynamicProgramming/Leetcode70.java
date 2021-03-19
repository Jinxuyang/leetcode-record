package dynamicProgramming;

/**
 * @Author Verge
 * @Date 2021/3/19 17:00
 * @Version 1.0
 */
public class Leetcode70 {
    /**
     * 思路：
     * 1. 要跳上最后一格可以从n-1跳一格上来，也可以从n-2跳两格上来
     * 2. 因此要跳上第n格的所有方法就是跳到n-1的方法数加上跳到n-2的方法数
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了11.64%的用户
     */
    public int climbStairs(int n) {
        if ( n == 1) return 1;
        if ( n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0]  = 1;
        dp[1]  = 2;
        for(int i = 2; i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 空间优化：
     * 1. 由于只用到n-1和n-2所以只存n-1和n-2其他不存
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35 MB, 在所有 Java 提交中击败了85.66%的用户
     */

    public int climbStairs1(int n) {
        if ( n == 1) return 1;
        if ( n == 2) return 2;
        int[] dp = new int[2];
        dp[0]  = 1;
        dp[1]  = 2;
        for(int i = 2; i < n;i++){
            dp[1] = dp[0] + dp[1];
            dp[0] = dp[1] - dp[0];
        }
        return dp[1];
    }
}
