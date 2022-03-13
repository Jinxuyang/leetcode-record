package sort;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2022/3/13 9:01
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,1,34,2,4,3,23,423324,234,3425,23,234,12,3124,5342423};
        //int[] arr = {3,2,1,4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = (R + L) >> 1;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int lp = L;
        int rp = mid + 1;

        while (lp <= mid && rp <= R) {
            if (arr[lp] < arr[rp]) {
                help[i++] = arr[lp++];
            } else {
                help[i++] = arr[rp++];
            }
        }

        if (lp > mid) {
            while (rp <= R) {
                help[i++] = arr[rp++];
            }
        } else if (rp > R) {
            while (lp <= mid) {
                help[i++] = arr[lp++];
            }
        }

        for (int k : help) {
            arr[L++] = k;
        }
    }


}
