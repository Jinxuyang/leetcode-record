package dp;

/**
 * @Author Verge
 * @Date 2022/4/21 19:52
 * @Version 1.0
 */
public class Leetcode213 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(
                tou(nums, 0, nums.length - 1),
                tou(nums, 1, nums.length)
        );
    }

    public int tou(int[] nums, int start, int end) {
        int[] dp = new int[end - start];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start + 1], nums[start]);
        for(int i = 2;i < dp.length;i++) {
            dp[i] = Math.max(nums[i + start] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
