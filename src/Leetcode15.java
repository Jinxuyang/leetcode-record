import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Verge
 * @Date 2021/3/16 19:44
 * @Version 1.0
 */
public class Leetcode15 {
    public static void main(String[] args) {
        int[] input = {0,0,0,1,1,3,4,4};
        System.out.println(threeSum(input));
    }

    /**
     * 思路：
     * 1. 首先排序
     * 2. 固定一个数，再用两个指针分别指向这个数的下一位和末尾
     * 3. 如果三个数之和小于0将front向前一定，大于零将rear向后移动，等于0则记录答案
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue; // 对于和前一个数字相同的数字直接跳过
            int front = i + 1,rear = nums.length - 1;
            while (front < rear) {
                int temp = nums[i] + nums[front] + nums[rear];
                if (temp > 0) rear--;
                else if (temp < 0) front++;
                else {
                    res.add(Arrays.asList(nums[i],nums[rear],nums[front])); //先得到一组正确答案
                    while (front < rear && nums[front] == nums[front + 1]) front++; // 对于重复的直接跳过
                    while (front < rear && nums[rear] == nums[rear - 1]) rear--;
                    rear--;
                    front++;
                }

            }
        }
        return res;
    }
}
