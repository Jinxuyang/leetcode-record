package hot100;

/**
 * @Author Verge
 * @Date 2022/3/25 20:09
 * @Version 1.0
 */
public class Code7 {
    public static void main(String[] args) {
        Code7 code7 = new Code7();
        System.out.println(code7.reverse(-1230));
    }
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;

        }
        return res;
    }
}
