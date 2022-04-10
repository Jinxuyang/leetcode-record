package hot100;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2022/4/10 14:25
 * @Version 1.0
 */
public class Code238 {
    public static void main(String[] args) {
        Code238 code238 = new Code238();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(code238.productExceptSelf1(nums)));
    }
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) return new int[]{0};
        if (nums.length == 2) return new int[]{nums[1], nums[0]};
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1;i < nums.length;i++) {
            left[i] = left[i - 1] * nums[i];
        }

        for(int i = nums.length - 2;i >= 0;i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            if (i - 1 < 0) res[i] = right[i + 1];
            else if (i + 1 >= nums.length) res[i] = left[i - 1];
            else res[i] = left[i - 1] * right[i + 1];
        }

        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        if (nums.length == 1) return new int[]{0};
        if (nums.length == 2) return new int[]{nums[1], nums[0]};
        int[] res = new int[nums.length];

        res[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2;i >= 0;i--) {
            res[i] = res[i + 1] * nums[i];
        }

        int L = 1;
        for(int i = 0;i < nums.length;i++) {
            if (i + 1 >= nums.length) res[i] = L;
            else res[i] = res[i + 1] * L;
            L *= nums[i];
        }

        return res;
    }
}
