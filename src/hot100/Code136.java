package hot100;

/**
 * @Author Verge
 * @Date 2022/4/3 11:30
 * @Version 1.0
 */
public class Code136 {
    public static void main(String[] args) {
        Code136 code136 = new Code136();
        int[] nums = {2,2,1};
        System.out.println(code136.singleNumber(nums));
    }

    /**
     * 使用异或运算
     * 1 xor 2 xor 1 == 1 xor 1 xor 2
     * 异或运算具有交换率
     * 两个相同的数异或结果为0，0与任何数异或结果不变
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
