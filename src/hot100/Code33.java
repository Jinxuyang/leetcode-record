package hot100;

/**
 * @Author Verge
 * @Date 2022/3/27 14:55
 * @Version 1.0
 */
public class Code33 {
    public static void main(String[] args) {
        Code33 code33 = new Code33();
        int[] nums = {5,1,2,3,4};
        System.out.println(code33.search(nums, 1));
    }
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (target == nums[mid]) return mid;
            if (nums[L] < nums[mid]) {
                if((target < nums[mid] && target >= nums[L]) || target == nums[L]) R = mid - 1;
                else L = mid + 1;
            } else {
                if ((target > nums[mid] && target <= nums[R]) || target == nums[R]) L = mid + 1;
                else R = mid - 1;
            }
        }

        return -1;
    }
}
