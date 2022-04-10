package hot100;

/**
 * @Author Verge
 * @Date 2022/4/10 16:07
 * @Version 1.0
 */
public class Code283 {
    public void moveZeroes(int[] nums) {
        int R = 0, L = 0;

        while(R < nums.length) {
            if(nums[R] != 0) {
                swap(nums, L, R);
                L++;
            }
            R++;
        }

    }

    public void swap(int[] nums, int i1,int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
