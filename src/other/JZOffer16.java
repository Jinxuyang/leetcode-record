package other;

/**
 * @Author Verge
 * @Date 2021/12/19 15:39
 * @Version 1.0
 */
public class JZOffer16 {

    // 会超时
    public static double myPow(double x, int n) {
        long temp = n;
        if (x == 1) return 1;
        double res = x;
        if (temp < 0) {
            temp = -temp;
            for(int i = 1;i < temp;i++) {
                res *= x;
            }
            if(res != 0) return 1.0/res;
            else return 0;

        } else if (temp > 0) {
            for(int i = 1;i < temp;i++) {
                res *= x;
            }
            return res;
        } else {
            return 1;
        }
    }

    /**
     * 快速幂
     * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
     */
    public static double myPow1(double x, int n) {
        long temp = n; // 直接给int的最小值加负号会溢出
        double res = 1;

        if (temp < 0) {
            x = 1 / x;
            temp = -temp;
        }

        while (temp != 0) {
            if ((temp & 1) == 1) {
                res *= x;
            }
            x *= x;
            temp >>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow1(2, 2));
    }
}
