package hot100;

/**
 * @Author Verge
 * @Date 2022/3/27 20:45
 * @Version 1.0
 */
public class Code55 {
    public static void main(String[] args) {
        Code55 code55 = new Code55();
        int[] nums = {3,2,1,0,4};
        System.out.println(code55.canJump1(nums));
    }
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                boolean flag = true;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] >= i - 1 - j + 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return false;
            }
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) return false;
            int length = nums[i] + i;
            maxIndex = Math.max(length, maxIndex);
        }
        return true;
    }
}
