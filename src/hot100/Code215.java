package hot100;

/**
 * @Author Verge
 * @Date 2022/4/7 17:19
 * @Version 1.0
 */
public class Code215 {
    int res = Integer.MIN_VALUE;
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        k = nums.length - k;
        int L= 0, R = nums.length - 1;
        int mid = partition(nums, L, R);
        while(true) {
            if(k > mid ) mid = partition(nums, mid + 1, R);
            else if (k < mid) mid = partition(nums, L, mid - 1);
            else return nums[mid];
        }
        //return 0;
    }


    public int partition(int[] nums, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int num = nums[(int) (Math.random() * (R - L)) + L];
        int big = R + 1, small = L - 1;
        int index = L;
        while(index < big) {
            if(nums[index] == num) index++;
            else if(nums[index] > num) swap(nums, index, --big);
            else swap(nums, index++, ++small);
        }
        return small + 1;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
