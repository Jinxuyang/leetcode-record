package hot100;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2022/3/26 11:14
 * @Version 1.0
 */
public class Code34 {
    public static void main(String[] args) {
        Code34 code34 = new Code34();
        int[] nums = {5,5};
        System.out.println(Arrays.toString(code34.searchRange1(nums, 5)));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums.length == 0) return res;
        int index = search(nums, 0, nums.length - 1, target);
        if (index == -1) return res;
        int L = index,R = index;
        while (L - 1 >= 0 && nums[L - 1] == target) {
            L--;
        }

        while (R + 1 < nums.length && nums[R + 1] == target) {
            R++;
        }
        res[0] = L;
        res[1] = R;
        return res;
    }

    public int search(int[] nums, int L, int R, int target) {
        if (L >= R && nums[L] != target) return -1;

        int mid = (L + R) / 2;
        if (nums[mid] == target) return mid;

        int res;
        if (nums[mid] > target) {
            res = search(nums, L, mid - 1, target);
        } else {
            res = search(nums, mid + 1, R, target);
        }

        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = search1(nums, target, true);
        int rightIdx = search1(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int search1(int[] nums, int target, boolean lower) {
        int L = 0, R = nums.length - 1;
        int ans = nums.length;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (nums[mid] > target || (lower && nums[mid] == target)){
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }
}
