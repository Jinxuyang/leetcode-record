package array;

/**
 * @Author Verge
 * @Date 2022/4/20 10:52
 * @Version 1.0
 */
public class NumArray {
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for(int i = 1;i < prefix.length;i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
