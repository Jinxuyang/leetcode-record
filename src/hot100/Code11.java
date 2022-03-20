package hot100;

/**
 * @Author Verge
 * @Date 2022/3/20 0:36
 * @Version 1.0
 */
public class Code11 {
    public static void main(String[] args) {
        Code11 code11 = new Code11();
        int[] ints = {1,8,6,2,5,4,8,3,7};
        System.out.println(code11.maxArea(ints));

    }

    public int maxArea(int[] height) {
        int L = 0, R = height.length - 1;

        int res = Integer.MIN_VALUE;
        while (L < R) {
            res = Math.max(res, (R - L) * Math.min(height[L], height[R]));
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }

        return res;
    }
}
