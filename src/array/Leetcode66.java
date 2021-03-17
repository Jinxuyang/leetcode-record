package array;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/3/15 19:52
 * @Version 1.0
 */
public class Leetcode66 {
    public static void main(String[] args) {
        int[] input = {9,8,8,9};
        System.out.println(Arrays.toString(plusOne(input)));
    }

    /**
     * 思路：思路不难主要要考虑到89999、99...这些特殊情况
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了98.72%的用户
     */
    public static int[] plusOne(int[] digits) {
        boolean flag = true;
        for (int digit : digits) {
            if (digit != 9) {
                flag = false;
                break;
            }
        }
        if (flag){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

        if (digits[digits.length - 1] == 9){
            for (int i = digits.length - 1; i >= 0 ; i--) {
                if (digits[i] + 1 >= 10){
                    digits[i] = 0;
                } else {
                    digits[i] ++;
                    break;
                }
            }
        } else {
            digits[digits.length - 1]++;
        }

        return  digits;

    }
}
