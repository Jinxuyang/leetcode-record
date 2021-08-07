package array;

public class JZOffer04 {
    /**
     * 思路见剑指offer
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (true) {
            if (matrix[i][j] > target) {
                if (j - 1 < 0) {
                    return false;
                } else {
                    j--;
                }
            } else if (matrix[i][j] < target) {
                if (i + 1 >= matrix.length) {
                    return false;
                } else {
                    i++;
                }
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{}};
        int target = 6;
        JZOffer04 jzOffer04 = new JZOffer04();
        System.out.println(jzOffer04.findNumberIn2DArray(a, target));
    }
}
