package other;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/12/20 10:13
 * @Version 1.0
 */
public class JZOffer17 {
    public static int[] printNumbers(int n) {
        int max = (int) (Math.pow(10,n) - 1);
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }


    /**
     *大数解法
     * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
     */
    static final char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] num;
    int n;
    int start ;
    int nine = 0;
    public int[] printNumbers1(int n) {
        this.n = n;
        start = n - 1;
        num = new char[n];
        dfs(0);
        return null;
    }

    StringBuilder res = new StringBuilder();
    public void dfs(int x) {
        if (x == n) {
            String numStr = String.valueOf(num).substring(start);

            if (!numStr.equals("0")) res.append(numStr).append(",");

            if (n - start == nine) start--;
            System.out.println(res);
            return;
        }

        for (char c : loop) {
            if (c == '9') nine++;
            num[x] = c;
            dfs(x + 1);
        }
        nine--;
    }
    public static void main(String[] args) {
        JZOffer17 jzOffer17 = new JZOffer17();
        jzOffer17.printNumbers1(3);
    }
}
