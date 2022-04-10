package hot100;

/**
 * @Author Verge
 * @Date 2022/4/10 16:08
 * @Version 1.0
 */
public class Code240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] > target) j--;
            else if(matrix[i][j] < target) i++;
            else return true;
        }
        return false;
    }
}
