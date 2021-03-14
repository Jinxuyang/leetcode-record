import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/3/13 21:16
 * @Version 1.0
 */
public class Leetcode189 {
    public static void main(String[] args) {
        int[] input = {-1,-100,3,99};
        rotate(input,2);
    }
    public static void rotate(int[] nums, int k) {
        int start = nums.length - k;
        int[] res = new int[nums.length];
        System.arraycopy(nums,start,res,0,k);
        System.arraycopy(nums,0,res,start-1,nums.length-k);
        System.arraycopy(res,0,nums,0,res.length);
        System.out.println(Arrays.toString(nums));
    }
}
