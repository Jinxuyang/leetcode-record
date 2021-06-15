package daliy;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/6/15 12:10
 * @Version 1.0
 */
public class Leetcode852 {
    public int peakIndexInMountainArray(int[] arr) {
        int i = -1,index = -1;
        for (int j = 0; j < arr.length; j++) {
            if (i < arr[j]) {
                i = arr[j];
                index = j;
            }
        }
        return index;
    }

    public static void main(String[] args) {

    }
}