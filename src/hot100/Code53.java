package hot100;

/**
 * @Author Verge
 * @Date 2022/3/26 11:02
 * @Version 1.0
 */
public class Code53 {
    public static void main(String[] args) {
        Code53 code53 = new Code53();
        int[] nums = {-1,-2};
        System.out.println(code53.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxVal = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) {
                dp[i]  = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            if (dp[i] > maxVal) maxVal = dp[i];
        }
        return maxVal;
    }
}
