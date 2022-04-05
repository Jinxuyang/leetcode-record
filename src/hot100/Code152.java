package hot100;

/**
 * @Author Verge
 * @Date 2022/4/4 20:27
 * @Version 1.0
 */
public class Code152 {
    public static void main(String[] args) {
        Code152 code152 = new Code152();
        int[] nums = {2,-1,1,1};
        System.out.println(code152.maxProduct1(nums));
//        code152.maxProduct(nums);
    }
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            res = Math.max(max, res);
        }

        return res;
    }

    public int maxProduct1(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            }

            res = Math.max(dp[i][0], res);
        }

        return res;
    }
}
