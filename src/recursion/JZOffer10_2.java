package recursion;

/**
 * @Author Verge
 * @Date 2021/10/30 15:00
 * @Version 1.0
 */
public class JZOffer10_2 {
    public static void main(String[] args) {
        JZOffer10_2 jzOffer10_2 = new JZOffer10_2();
        System.out.println(jzOffer10_2.numWays(3));
    }

    public int numWays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return numWays(n - 1) + numWays(n - 2);
    }

    public int numWays1(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
