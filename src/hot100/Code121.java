package hot100;

/**
 * @Author Verge
 * @Date 2022/3/30 14:32
 * @Version 1.0
 */
public class Code121 {
    public static void main(String[] args) {
        Code121 code121 = new Code121();
        int[] nums = {7};
        System.out.println(code121.maxProfit(nums));
    }
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > res) res = prices[i] - min;
            if (prices[i] < min) min = prices[i];
        }

        return res;
    }
}
