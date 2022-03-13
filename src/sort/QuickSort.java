package sort;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2022/3/13 9:30
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr1 = {2,3,4,5,1,34,2,4,3,23,423324,234,3425,23,234,12,3124,5342423,3254,234365,547,43,23123,3124,312,23,5423,32,432,234,2,3412,12,34231};
        int[] arr = {2,3,4,5,1,34,2,4,3,23,423324,234,3425,23,234,12,3124,5342423,3254,234365,547,43,23123,3124,312,23,5423,32,432,234,2,3412,12,34231};
        quickSort(arr, 0, arr.length - 1);
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) return;
        int[] area = partition(arr, L, R);
        quickSort(arr, L, area[0]);
        quickSort(arr, area[1], R);
    }

    public static int[] partition(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }

        int i = L;
        int minArea = L - 1;
        int maxArea = R + 1;
        int num = arr[(int) (Math.random() * (R - L)) + L];
        while (i < maxArea) {
            if (arr[i] < num) {
                swap(arr, ++minArea, i++);
            } else if (arr[i] > num) {
                swap(arr, --maxArea, i);
            } else {
                i++;
            }
        }
        return new int[]{minArea,maxArea};
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
