package recursion;

/**
 * @Author Verge
 * @Date 2021/10/30 14:36
 * @Version 1.0
 */
public class JZOffer10_1 {
    public static void main(String[] args) {
        JZOffer10_1 jzOffer10_1 = new JZOffer10_1();
        //System.out.println(jzOffer10_1.fib(48));
        System.out.println(jzOffer10_1.fib1(48));
        // 0 1 1 2 3 5
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        int x = 0,y = 1;
        int res;
        for (int i = 0; i < n; i++) {
            res = (x + y) % 1000000007;
            x = y;
            y = res;
        }
        return x;
    }
    
    
}
