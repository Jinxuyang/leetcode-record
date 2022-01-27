package array;

/**
 * @Author Verge
 * @Date 2022/1/27 13:33
 * @Version 1.0
 */
public class JZOffer29 {
    // 没写出
    public static void main(String[] args) {
        JZOffer29 jzOffer29 = new JZOffer29();
        int[][] m = {{1,2,3,4}};
        jzOffer29.spiralOrder(m);
    }
    public int[] spiralOrder(int[][] matrix) {
        int x = 0, y = 0;
        int ye = matrix.length - 1,xe = matrix[0].length - 1;
        int ys = 0, xs = 0;
        int max = matrix.length * matrix[0].length;
        int cnt = 0;
        while (cnt < max) {
            while(x < xe) {
                System.out.println(matrix[y][x]);
                x++;
                cnt++;
            }
            ys++;
            while (y < ye) {
                System.out.println(matrix[y][x]);
                y++;
                cnt++;
            }
            xe--;
            while (x > xs) {
                System.out.println(matrix[y][x]);
                x--;
                cnt++;
            }
            ye--;
            while (y > ys) {
                System.out.println(matrix[y][x]);
                y--;
                cnt++;
            }
            xs++;
        }
        return null;
        //System.out.println(matrix[(matrix.length - 1)/2][(matrix[0].length - 1)/2]);
        //return null;
    }
    // 1 2 3
    // 4 5 6
    // 7 8 9


    // 1 2  3  4
    // 5 6  7  8
    // 9 10 11 12
}
