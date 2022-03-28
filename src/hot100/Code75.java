package hot100;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2022/3/28 21:26
 * @Version 1.0
 */
public class Code75 {
    public static void main(String[] args) {
        Code75 code75 = new Code75();
        int[] nums = {2,0,2,1,1,0};
        code75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int L = -1, R = nums.length;

        int i = 0;
        while (i < R) {
            if (nums[i] == 0) swap(nums, ++L, i++);
            else if (nums[i] == 2) swap(nums, --R, i);
            else i++;
        }
    }

    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
