package hot100;

/**
 * @Author Verge
 * @Date 2022/4/5 15:02
 * @Version 1.0
 */
public class Code169 {
    public static void main(String[] args) {
        Code169 code169 = new Code169();
        int[] nums = {2,1,1,2,2};
        System.out.println(code169.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else {
                if (nums[i] == res) count++;
                else count--;
            }
        }
        return res;
    }
}
