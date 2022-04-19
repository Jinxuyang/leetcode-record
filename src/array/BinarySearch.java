package array;

/**
 * @Author Verge
 * @Date 2022/4/19 17:48
 * @Version 1.0
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
