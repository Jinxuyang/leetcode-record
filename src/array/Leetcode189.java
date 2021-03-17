package array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author Verge
 * @Date 2021/3/13 21:16
 * @Version 1.0
 */
public class Leetcode189 {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        rotate(input,2);

    }

    /**
     * 思路：
     * 1. 用(i + k) % nums.length计算出每个数字变换后的下标
     */
    public static void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(res,0,nums,0,nums.length);
        //System.out.println(Arrays.toString(nums));
    }

    /*public static void rotate1(int[] nums, int k) {
        int nowIndex = 0;
        int des = (nowIndex + k) % nums.length;
        int temp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[des] = temp;
            des = (nowIndex + k) % nums.length;
            temp = nums[des];
            nowIndex = des;


        }
        System.out.println(Arrays.toString(nums));
    }*/
}
