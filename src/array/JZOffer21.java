package array;

/**
 * @Author Verge
 * @Date 2021/12/22 20:00
 * @Version 1.0
 */
public class JZOffer21 {
    public int[] exchange(int[] nums) {
        int front = 0, end = nums.length - 1;
        while(front <= end) {
            if(nums[front] % 2 == 1) {
                front++;
            }
            if(nums[end] % 2 == 0) {
                end--;
            }
            if (front <= end && nums[front] % 2 == 0 && nums[end] % 2 == 1) {
                int swap = nums[front];
                nums[front] = nums[end];
                nums[end] = swap;
                front++;
                end--;
            }
        }
        return nums;
    }
}
