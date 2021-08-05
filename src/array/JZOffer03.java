package array;

public class JZOffer03 {
    /**
     * 思路：使用一个和原数组一样大的数组，出现数字1就令数组下标为1处+1，当出现>1时说明该数字重复返回下表
     * 时间复杂度O(n),但使用了额外的存储空间
     */
    public int findRepeatNumber(int[] nums) {
        int[] cnt = new int[nums.length];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] >= 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 思路： 剑指offer的解法
     */
    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {

                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        JZOffer03 jzOffer03 = new JZOffer03();
        int[] nums = {2, 3, 1, 2, 2, 3};
        System.out.println(jzOffer03.findRepeatNumber1(nums));
    }


}
