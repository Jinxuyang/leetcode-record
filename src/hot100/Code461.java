package hot100;

/**
 * @Author Verge
 * @Date 2022/4/3 21:27
 * @Version 1.0
 */
public class Code461 {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        while (temp != 0) {
            res += temp & 1;
            temp = temp >> 1;
        }

        return res;
    }
}
