package hot100;

/**
 * @Author Verge
 * @Date 2022/4/6 16:02
 * @Version 1.0
 */
public class Code198 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for(int i = 1;i < nums.length;i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.max(dp[nums.length -1][0], dp[nums.length -1][1]);
    }
}
